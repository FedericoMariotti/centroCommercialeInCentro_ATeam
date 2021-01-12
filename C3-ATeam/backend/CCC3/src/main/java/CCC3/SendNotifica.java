package CCC3;
/**
 * @author Fabio Lori 2
 *
 */
public class SendNotifica {

	static void send(String deviceToken,String message,String title) {
		OkHttpClient client = new OkHttpClient();
        MediaType mediaType = MediaType.parse("application/json");
        JSONObject obj = new JSONObject();
        JSONObject msgObject = new JSONObject();
        msgObject.put("body", message);
        msgObject.put("title", title);
        msgObject.put("icon", ANDROID_NOTIFICATION_ICON);
        msgObject.put("color", ANDROID_NOTIFICATION_COLOR);

        obj.put("to", deviceToken);
        obj.put("notification",msgObject);

        RequestBody body = RequestBody.create(mediaType, obj.toString());
        Request request = new Request.Builder().url(ANDROID_NOTIFICATION_URL).post(body)
                .addHeader("content-type", CONTENT_TYPE)
                .addHeader("authorization", "key="+ANDROID_NOTIFICATION_KEY).build();

        Response response = client.newCall(request).execute();
        logger.debug("Notification response >>>" +response.body().string());
    }
	}


