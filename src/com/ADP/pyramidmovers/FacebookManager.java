package com.ADP.pyramidmovers;

import java.util.Arrays;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;

import com.ADP.controller.ResourceController;
import com.facebook.FacebookException;
import com.facebook.FacebookOperationCanceledException;
import com.facebook.HttpMethod;
import com.facebook.Request;
import com.facebook.RequestAsyncTask;
import com.facebook.Response;
import com.facebook.Session;
import com.facebook.Session.Builder;
import com.facebook.Session.OpenRequest;
import com.facebook.Session.StatusCallback;
import com.facebook.SessionLoginBehavior;
import com.facebook.SessionState;
import com.facebook.model.GraphUser;
import com.facebook.widget.WebDialog;
import com.facebook.widget.WebDialog.OnCompleteListener;

public class FacebookManager {
	
	static Activity activity  =ResourceController.getInstance().activity;
	private static final List<String> PERMISSIONS = Arrays.asList("publish_actions" , "user_likes");
	public static String fbUsername;
    public static boolean useFacebook;
    private static Session openActiveSession(Activity activity, boolean allowLoginUI, StatusCallback callback, List<String> permissions) {
        OpenRequest openRequest = new OpenRequest(activity).setPermissions(permissions).setCallback(callback);
        openRequest.setLoginBehavior(SessionLoginBehavior.SUPPRESS_SSO);
        Session session = new Builder(activity).build();
        if (SessionState.CREATED_TOKEN_LOADED.equals(session.getState()) || allowLoginUI) {
            Session.setActiveSession(session);
            session.openForPublish(openRequest);
            return session;
        }
        return null;
    }

    private static void loginAndPost(final String pData) {
		activity.runOnUiThread(new Runnable() {
			@Override
			public void run() {
				openActiveSession(activity, true, new Session.StatusCallback() {
					@Override
					public void call(Session session, SessionState state, Exception exception) {
						if (session.isOpened()) {
							Request.executeMeRequestAsync(session, new Request.GraphUserCallback() {
								@Override
								public void onCompleted(GraphUser user, Response response) {
									if (user != null) {
										fbUsername = user.getFirstName();
										final Session.OpenRequest openRequest;
										openRequest = new Session.OpenRequest(activity);
										openRequest.setPermissions(PERMISSIONS);
										facebookFeedDialog(user.getFirstName(), pData);
									} else {
										useFacebook = false;
									}
								}
							});
						}
					}
				}, PERMISSIONS);
			}
		});
	}
	public static void facebookLogin() {
		Session.openActiveSession(activity, true, new Session.StatusCallback() {   
		@Override
		public void call(Session session, SessionState state, Exception exception) {
		        if (session.isOpened()) {
		        Request.executeMeRequestAsync(session, new Request.GraphUserCallback() {
		                @Override
		                public void onCompleted(GraphUser user, Response response) {
		                        if (user != null) {
		                        // CALLBACK: USER IS LOGGED IN
		                        // DO YOUR STUFF HERE
		                        fbUsername = user.getFirstName();
		                        Session.OpenRequest openRequest;
                                openRequest = new Session.OpenRequest(activity);
                                openRequest.setPermissions(PERMISSIONS);
		                        useFacebook = true;
		                        
		                        // this will save the users first name to a public variable fbUsername
		                        }else{
			                    useFacebook = false;

		                        }
		                }
		        });
		        }
		}
		});
		}
	
	public static void facebookRequestDialog() {
		activity.runOnUiThread(new Runnable() {

			@Override
			public void run() {
				openActiveSession(activity, true, new Session.StatusCallback() {
					@Override
					public void call(Session session, SessionState state, Exception exception) {
						if (session.isOpened()) {
							Request.executeMeRequestAsync(session, new Request.GraphUserCallback() {

								@Override
								public void onCompleted(GraphUser user,
										Response response) {
									   Bundle params = new Bundle();
								        params.putString("message", "The pharaoh needs your help moving his pyramids! Help him and he shall reward you!!");
								 
										WebDialog requestsDialog = (new WebDialog.RequestsDialogBuilder(activity, Session.getActiveSession(), params)).setOnCompleteListener(new OnCompleteListener() {
										        
												@Override
												public void onComplete(Bundle values, FacebookException error) {
													if (error != null) {
										                if (error instanceof FacebookOperationCanceledException) { 
										                	Toast.makeText(activity.getApplicationContext(), 
									                                "Request cancelled", 
									                                Toast.LENGTH_SHORT).show();
										                        // Request cancelled
										                } else {
										                	Toast.makeText(activity.getApplicationContext(), 
									                                "Network Error", 
									                                Toast.LENGTH_SHORT).show();
										                        // Network Error
										                }
										        } else {
										                final String requestId = values.getString("request");
										                if (requestId != null) { 
										                	Toast.makeText(activity.getApplicationContext(), 
									                                "Request sent", 
									                                Toast.LENGTH_SHORT).show();
										                        // Request sent
										                } else {
										                	Toast.makeText(activity.getApplicationContext(), 
									                                "Request cancelled", 
									                                Toast.LENGTH_SHORT).show();
										                        // Request cancelled
										                }
										        }     
													
												}
										}).build();
										requestsDialog.show();
										
								}
									
								
							});
						}
					}
				}, PERMISSIONS);
								
		     
			}});
	}
	
	
	public static void facebookFeedDialog(final String pName, final String pData) {
		activity.runOnUiThread(new Runnable() {

			@Override
			public void run() {
				Bundle params = new Bundle();
				params.putString("name" , pName + pData);
				params.putString("caption", "Pyramid Mover on Android");
				params.putString("description", "The pharaoh needs your help! He must move his pyramids to a new location! Solve his problems and be rewarded!");
				params.putString("link", "https://play.google.com/store/apps/details?id=com.ADP.pyramidmovers");
				params.putString("picture", "http://imgur.com/PHaeGmI");
				 
				WebDialog feedDialog = (new WebDialog.FeedDialogBuilder(activity, Session.getActiveSession(), params)).setOnCompleteListener(new OnCompleteListener() {
				        @Override
				        public void onComplete(Bundle values, FacebookException error) {
				                if (error == null) {
				                        final String postId = values.getString("post_id");
				                        if (postId != null) {
				                        // POSTED
				                        } else {
				                        // POST CANCELLED
				                        }
				                } else if (error instanceof FacebookOperationCanceledException) {
				                        // POST CANCELLED
				                        } else {
				                        // ERROR POSTING
				                        }
				                }
				 
					}).build();
				;
				feedDialog.show();
				
			}});
	

		}
	
	public static void linkToPage() {
		activity.runOnUiThread(new Runnable() {
			@Override
			public void run() {
				openActiveSession(activity, true, new Session.StatusCallback() {
					@Override
					public void call(Session session, SessionState state, Exception exception) {
						if (session.isOpened()) {
							Request.executeMeRequestAsync(session, new Request.GraphUserCallback() {
								@Override
								public void onCompleted(GraphUser user, Response response) {
									
									if (user != null) {
										try{
											String facebookScheme = "fb://profile/281335115341835";
							                Intent facebookIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(facebookScheme));
							                activity.startActivity(facebookIntent);
										}catch(Exception e){
	
											activity.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.facebook.com/281335115341835")));
										}
									} else {
										useFacebook = false;
									}
								}
							});
						}
					}
				}, PERMISSIONS);
			}
		});
	}
	
	
	
	public static void checkUserLoggedIn() {
		activity.runOnUiThread(new Runnable() {
			@Override
			public void run() {
				openActiveSession(activity, true, new Session.StatusCallback() {
					@Override
					public void call(Session session, SessionState state, Exception exception) {
						if (session.isOpened()) {
							Request.executeMeRequestAsync(session, new Request.GraphUserCallback() {
								@Override
								public void onCompleted(GraphUser user, Response response) {
									if (user != null) {
										fbUsername = user.getFirstName();
										FacebookManager.useFacebook = true;
									} else {
										FacebookManager.useFacebook = false;
									}
								}
							});
						}
					}
				}, PERMISSIONS);
			}
		});
	}
	public static void checkLikeStatus() {
		activity.runOnUiThread(new Runnable() {

			@Override
			public void run() {
        final Session session = Session.getActiveSession();
        if (session != null) {
                Request.Callback callback = new Request.Callback() {

                        @Override
                        public void onCompleted(Response response) {
                                if (response.getGraphObject() != null) {
                                        try {
                                                if (!response.getGraphObject().getInnerJSONObject()
                                                                .getString("data").equalsIgnoreCase("[]")) {
                                                	((GameActivity) activity).unLockLevel(100, "true");   
                    								((GameActivity) activity).setLevelBeat(100,"true");}
                                        } catch (JSONException e) {
                                                // TODO Auto-generated catch block
                                                e.printStackTrace();
                                        }
                                }
                        }
                };
                Request request = new Request(session, "me/likes/" + "281335115341835",
                                null, HttpMethod.GET, callback);
                RequestAsyncTask task = new RequestAsyncTask(request);
                task.execute();
        }
	}
});

}
	public static void postLevelCompletionTime(final String pLevel, final String pGameMode, final String pMoves, final String pTime) {
		if (useFacebook) {
			facebookFeedDialog(fbUsername, " has completed Level " + pLevel + " on " + pGameMode + " with only " + pMoves + " moves in only " + pTime +" seconds in Pyramid Mover");
		} else {
			loginAndPost(" has completed Level " + pLevel + " on " + pGameMode + " with only " + pMoves + " moves in only " + pTime +" seconds in Pyramid Mover");
		}
	}
	
	public static void postLevelCompletionMove(final String pLevel, final String pGameMode, final String pMoves) {
		if (useFacebook) {
			facebookFeedDialog(fbUsername, " has completed Level " + pLevel + " on " + pGameMode + " with only " + pMoves +" moves in Pyramid Mover");
		} else {
			loginAndPost(" has completed Level " + pLevel + " on " + pGameMode  + " with only " + pMoves + " moves in Pyramid Mover");
		}
	}
	
	public static void postLevelCompletionOrder(final String pLevel, final String pGameMode, final String pMoves, final String pTime) {
		if (useFacebook) {
			facebookFeedDialog(fbUsername, " has completed Level " + pLevel + " on " + pGameMode + " with only " + pMoves + " moves in only " + pTime +" seconds in Pyramid Mover");
		} else {
			loginAndPost(" has completed Level " + pLevel + " on " + pGameMode + " with only " + pMoves + " moves in only " + pTime +" seconds in Pyramid Mover");
		}
	}
}
