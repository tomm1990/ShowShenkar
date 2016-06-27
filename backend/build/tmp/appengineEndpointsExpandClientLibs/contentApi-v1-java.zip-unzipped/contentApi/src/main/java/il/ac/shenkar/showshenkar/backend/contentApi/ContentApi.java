/*
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
/*
 * This code was generated by https://github.com/google/apis-client-generator/
 * (build: 2016-05-27 16:00:31 UTC)
 * on 2016-06-27 at 13:19:44 UTC 
 * Modify at your own risk.
 */

package il.ac.shenkar.showshenkar.backend.contentApi;

/**
 * Service definition for ContentApi (v1).
 *
 * <p>
 * This is an API
 * </p>
 *
 * <p>
 * For more information about this service, see the
 * <a href="" target="_blank">API Documentation</a>
 * </p>
 *
 * <p>
 * This service uses {@link ContentApiRequestInitializer} to initialize global parameters via its
 * {@link Builder}.
 * </p>
 *
 * @since 1.3
 * @author Google, Inc.
 */
@SuppressWarnings("javadoc")
public class ContentApi extends com.google.api.client.googleapis.services.json.AbstractGoogleJsonClient {

  // Note: Leave this static initializer at the top of the file.
  static {
    com.google.api.client.util.Preconditions.checkState(
        com.google.api.client.googleapis.GoogleUtils.MAJOR_VERSION == 1 &&
        com.google.api.client.googleapis.GoogleUtils.MINOR_VERSION >= 15,
        "You are currently running with version %s of google-api-client. " +
        "You need at least version 1.15 of google-api-client to run version " +
        "1.22.0 of the contentApi library.", com.google.api.client.googleapis.GoogleUtils.VERSION);
  }

  /**
   * The default encoded root URL of the service. This is determined when the library is generated
   * and normally should not be changed.
   *
   * @since 1.7
   */
  public static final String DEFAULT_ROOT_URL = "https://shenkarshow.appspot.com/_ah/api/";

  /**
   * The default encoded service path of the service. This is determined when the library is
   * generated and normally should not be changed.
   *
   * @since 1.7
   */
  public static final String DEFAULT_SERVICE_PATH = "contentApi/v1/";

  /**
   * The default encoded base URL of the service. This is determined when the library is generated
   * and normally should not be changed.
   */
  public static final String DEFAULT_BASE_URL = DEFAULT_ROOT_URL + DEFAULT_SERVICE_PATH;

  /**
   * Constructor.
   *
   * <p>
   * Use {@link Builder} if you need to specify any of the optional parameters.
   * </p>
   *
   * @param transport HTTP transport, which should normally be:
   *        <ul>
   *        <li>Google App Engine:
   *        {@code com.google.api.client.extensions.appengine.http.UrlFetchTransport}</li>
   *        <li>Android: {@code newCompatibleTransport} from
   *        {@code com.google.api.client.extensions.android.http.AndroidHttp}</li>
   *        <li>Java: {@link com.google.api.client.googleapis.javanet.GoogleNetHttpTransport#newTrustedTransport()}
   *        </li>
   *        </ul>
   * @param jsonFactory JSON factory, which may be:
   *        <ul>
   *        <li>Jackson: {@code com.google.api.client.json.jackson2.JacksonFactory}</li>
   *        <li>Google GSON: {@code com.google.api.client.json.gson.GsonFactory}</li>
   *        <li>Android Honeycomb or higher:
   *        {@code com.google.api.client.extensions.android.json.AndroidJsonFactory}</li>
   *        </ul>
   * @param httpRequestInitializer HTTP request initializer or {@code null} for none
   * @since 1.7
   */
  public ContentApi(com.google.api.client.http.HttpTransport transport, com.google.api.client.json.JsonFactory jsonFactory,
      com.google.api.client.http.HttpRequestInitializer httpRequestInitializer) {
    this(new Builder(transport, jsonFactory, httpRequestInitializer));
  }

  /**
   * @param builder builder
   */
  ContentApi(Builder builder) {
    super(builder);
  }

  @Override
  protected void initialize(com.google.api.client.googleapis.services.AbstractGoogleClientRequest<?> httpClientRequest) throws java.io.IOException {
    super.initialize(httpClientRequest);
  }

  /**
   * Create a request for the method "deleteContent".
   *
   * This request holds the parameters needed by the contentApi server.  After setting any optional
   * parameters, call the {@link DeleteContent#execute()} method to invoke the remote operation.
   *
   * @param id
   * @return the request
   */
  public DeleteContent deleteContent(java.lang.String id) throws java.io.IOException {
    DeleteContent result = new DeleteContent(id);
    initialize(result);
    return result;
  }

  public class DeleteContent extends ContentApiRequest<il.ac.shenkar.showshenkar.backend.contentApi.model.Content> {

    private static final String REST_PATH = "contentApi/{id}";

    /**
     * Create a request for the method "deleteContent".
     *
     * This request holds the parameters needed by the the contentApi server.  After setting any
     * optional parameters, call the {@link DeleteContent#execute()} method to invoke the remote
     * operation. <p> {@link DeleteContent#initialize(com.google.api.client.googleapis.services.Abstra
     * ctGoogleClientRequest)} must be called to initialize this instance immediately after invoking
     * the constructor. </p>
     *
     * @param id
     * @since 1.13
     */
    protected DeleteContent(java.lang.String id) {
      super(ContentApi.this, "DELETE", REST_PATH, null, il.ac.shenkar.showshenkar.backend.contentApi.model.Content.class);
      this.id = com.google.api.client.util.Preconditions.checkNotNull(id, "Required parameter id must be specified.");
    }

    @Override
    public DeleteContent setAlt(java.lang.String alt) {
      return (DeleteContent) super.setAlt(alt);
    }

    @Override
    public DeleteContent setFields(java.lang.String fields) {
      return (DeleteContent) super.setFields(fields);
    }

    @Override
    public DeleteContent setKey(java.lang.String key) {
      return (DeleteContent) super.setKey(key);
    }

    @Override
    public DeleteContent setOauthToken(java.lang.String oauthToken) {
      return (DeleteContent) super.setOauthToken(oauthToken);
    }

    @Override
    public DeleteContent setPrettyPrint(java.lang.Boolean prettyPrint) {
      return (DeleteContent) super.setPrettyPrint(prettyPrint);
    }

    @Override
    public DeleteContent setQuotaUser(java.lang.String quotaUser) {
      return (DeleteContent) super.setQuotaUser(quotaUser);
    }

    @Override
    public DeleteContent setUserIp(java.lang.String userIp) {
      return (DeleteContent) super.setUserIp(userIp);
    }

    @com.google.api.client.util.Key
    private java.lang.String id;

    /**

     */
    public java.lang.String getId() {
      return id;
    }

    public DeleteContent setId(java.lang.String id) {
      this.id = id;
      return this;
    }

    @Override
    public DeleteContent set(String parameterName, Object value) {
      return (DeleteContent) super.set(parameterName, value);
    }
  }

  /**
   * Create a request for the method "getContent".
   *
   * This request holds the parameters needed by the contentApi server.  After setting any optional
   * parameters, call the {@link GetContent#execute()} method to invoke the remote operation.
   *
   * @param id
   * @return the request
   */
  public GetContent getContent(java.lang.Long id) throws java.io.IOException {
    GetContent result = new GetContent(id);
    initialize(result);
    return result;
  }

  public class GetContent extends ContentApiRequest<il.ac.shenkar.showshenkar.backend.contentApi.model.Content> {

    private static final String REST_PATH = "contentApi/{id}";

    /**
     * Create a request for the method "getContent".
     *
     * This request holds the parameters needed by the the contentApi server.  After setting any
     * optional parameters, call the {@link GetContent#execute()} method to invoke the remote
     * operation. <p> {@link
     * GetContent#initialize(com.google.api.client.googleapis.services.AbstractGoogleClientRequest)}
     * must be called to initialize this instance immediately after invoking the constructor. </p>
     *
     * @param id
     * @since 1.13
     */
    protected GetContent(java.lang.Long id) {
      super(ContentApi.this, "GET", REST_PATH, null, il.ac.shenkar.showshenkar.backend.contentApi.model.Content.class);
      this.id = com.google.api.client.util.Preconditions.checkNotNull(id, "Required parameter id must be specified.");
    }

    @Override
    public com.google.api.client.http.HttpResponse executeUsingHead() throws java.io.IOException {
      return super.executeUsingHead();
    }

    @Override
    public com.google.api.client.http.HttpRequest buildHttpRequestUsingHead() throws java.io.IOException {
      return super.buildHttpRequestUsingHead();
    }

    @Override
    public GetContent setAlt(java.lang.String alt) {
      return (GetContent) super.setAlt(alt);
    }

    @Override
    public GetContent setFields(java.lang.String fields) {
      return (GetContent) super.setFields(fields);
    }

    @Override
    public GetContent setKey(java.lang.String key) {
      return (GetContent) super.setKey(key);
    }

    @Override
    public GetContent setOauthToken(java.lang.String oauthToken) {
      return (GetContent) super.setOauthToken(oauthToken);
    }

    @Override
    public GetContent setPrettyPrint(java.lang.Boolean prettyPrint) {
      return (GetContent) super.setPrettyPrint(prettyPrint);
    }

    @Override
    public GetContent setQuotaUser(java.lang.String quotaUser) {
      return (GetContent) super.setQuotaUser(quotaUser);
    }

    @Override
    public GetContent setUserIp(java.lang.String userIp) {
      return (GetContent) super.setUserIp(userIp);
    }

    @com.google.api.client.util.Key
    private java.lang.Long id;

    /**

     */
    public java.lang.Long getId() {
      return id;
    }

    public GetContent setId(java.lang.Long id) {
      this.id = id;
      return this;
    }

    @Override
    public GetContent set(String parameterName, Object value) {
      return (GetContent) super.set(parameterName, value);
    }
  }

  /**
   * Create a request for the method "setContent".
   *
   * This request holds the parameters needed by the contentApi server.  After setting any optional
   * parameters, call the {@link SetContent#execute()} method to invoke the remote operation.
   *
   * @param content the {@link il.ac.shenkar.showshenkar.backend.contentApi.model.Content}
   * @return the request
   */
  public SetContent setContent(il.ac.shenkar.showshenkar.backend.contentApi.model.Content content) throws java.io.IOException {
    SetContent result = new SetContent(content);
    initialize(result);
    return result;
  }

  public class SetContent extends ContentApiRequest<il.ac.shenkar.showshenkar.backend.contentApi.model.Content> {

    private static final String REST_PATH = "contentApi";

    /**
     * Create a request for the method "setContent".
     *
     * This request holds the parameters needed by the the contentApi server.  After setting any
     * optional parameters, call the {@link SetContent#execute()} method to invoke the remote
     * operation. <p> {@link
     * SetContent#initialize(com.google.api.client.googleapis.services.AbstractGoogleClientRequest)}
     * must be called to initialize this instance immediately after invoking the constructor. </p>
     *
     * @param content the {@link il.ac.shenkar.showshenkar.backend.contentApi.model.Content}
     * @since 1.13
     */
    protected SetContent(il.ac.shenkar.showshenkar.backend.contentApi.model.Content content) {
      super(ContentApi.this, "POST", REST_PATH, content, il.ac.shenkar.showshenkar.backend.contentApi.model.Content.class);
    }

    @Override
    public SetContent setAlt(java.lang.String alt) {
      return (SetContent) super.setAlt(alt);
    }

    @Override
    public SetContent setFields(java.lang.String fields) {
      return (SetContent) super.setFields(fields);
    }

    @Override
    public SetContent setKey(java.lang.String key) {
      return (SetContent) super.setKey(key);
    }

    @Override
    public SetContent setOauthToken(java.lang.String oauthToken) {
      return (SetContent) super.setOauthToken(oauthToken);
    }

    @Override
    public SetContent setPrettyPrint(java.lang.Boolean prettyPrint) {
      return (SetContent) super.setPrettyPrint(prettyPrint);
    }

    @Override
    public SetContent setQuotaUser(java.lang.String quotaUser) {
      return (SetContent) super.setQuotaUser(quotaUser);
    }

    @Override
    public SetContent setUserIp(java.lang.String userIp) {
      return (SetContent) super.setUserIp(userIp);
    }

    @Override
    public SetContent set(String parameterName, Object value) {
      return (SetContent) super.set(parameterName, value);
    }
  }

  /**
   * Create a request for the method "updateContent".
   *
   * This request holds the parameters needed by the contentApi server.  After setting any optional
   * parameters, call the {@link UpdateContent#execute()} method to invoke the remote operation.
   *
   * @param id
   * @return the request
   */
  public UpdateContent updateContent(java.lang.String id) throws java.io.IOException {
    UpdateContent result = new UpdateContent(id);
    initialize(result);
    return result;
  }

  public class UpdateContent extends ContentApiRequest<il.ac.shenkar.showshenkar.backend.contentApi.model.Content> {

    private static final String REST_PATH = "contentApi/{id}";

    /**
     * Create a request for the method "updateContent".
     *
     * This request holds the parameters needed by the the contentApi server.  After setting any
     * optional parameters, call the {@link UpdateContent#execute()} method to invoke the remote
     * operation. <p> {@link UpdateContent#initialize(com.google.api.client.googleapis.services.Abstra
     * ctGoogleClientRequest)} must be called to initialize this instance immediately after invoking
     * the constructor. </p>
     *
     * @param id
     * @since 1.13
     */
    protected UpdateContent(java.lang.String id) {
      super(ContentApi.this, "PUT", REST_PATH, null, il.ac.shenkar.showshenkar.backend.contentApi.model.Content.class);
      this.id = com.google.api.client.util.Preconditions.checkNotNull(id, "Required parameter id must be specified.");
    }

    @Override
    public UpdateContent setAlt(java.lang.String alt) {
      return (UpdateContent) super.setAlt(alt);
    }

    @Override
    public UpdateContent setFields(java.lang.String fields) {
      return (UpdateContent) super.setFields(fields);
    }

    @Override
    public UpdateContent setKey(java.lang.String key) {
      return (UpdateContent) super.setKey(key);
    }

    @Override
    public UpdateContent setOauthToken(java.lang.String oauthToken) {
      return (UpdateContent) super.setOauthToken(oauthToken);
    }

    @Override
    public UpdateContent setPrettyPrint(java.lang.Boolean prettyPrint) {
      return (UpdateContent) super.setPrettyPrint(prettyPrint);
    }

    @Override
    public UpdateContent setQuotaUser(java.lang.String quotaUser) {
      return (UpdateContent) super.setQuotaUser(quotaUser);
    }

    @Override
    public UpdateContent setUserIp(java.lang.String userIp) {
      return (UpdateContent) super.setUserIp(userIp);
    }

    @com.google.api.client.util.Key
    private java.lang.String id;

    /**

     */
    public java.lang.String getId() {
      return id;
    }

    public UpdateContent setId(java.lang.String id) {
      this.id = id;
      return this;
    }

    @Override
    public UpdateContent set(String parameterName, Object value) {
      return (UpdateContent) super.set(parameterName, value);
    }
  }

  /**
   * Builder for {@link ContentApi}.
   *
   * <p>
   * Implementation is not thread-safe.
   * </p>
   *
   * @since 1.3.0
   */
  public static final class Builder extends com.google.api.client.googleapis.services.json.AbstractGoogleJsonClient.Builder {

    /**
     * Returns an instance of a new builder.
     *
     * @param transport HTTP transport, which should normally be:
     *        <ul>
     *        <li>Google App Engine:
     *        {@code com.google.api.client.extensions.appengine.http.UrlFetchTransport}</li>
     *        <li>Android: {@code newCompatibleTransport} from
     *        {@code com.google.api.client.extensions.android.http.AndroidHttp}</li>
     *        <li>Java: {@link com.google.api.client.googleapis.javanet.GoogleNetHttpTransport#newTrustedTransport()}
     *        </li>
     *        </ul>
     * @param jsonFactory JSON factory, which may be:
     *        <ul>
     *        <li>Jackson: {@code com.google.api.client.json.jackson2.JacksonFactory}</li>
     *        <li>Google GSON: {@code com.google.api.client.json.gson.GsonFactory}</li>
     *        <li>Android Honeycomb or higher:
     *        {@code com.google.api.client.extensions.android.json.AndroidJsonFactory}</li>
     *        </ul>
     * @param httpRequestInitializer HTTP request initializer or {@code null} for none
     * @since 1.7
     */
    public Builder(com.google.api.client.http.HttpTransport transport, com.google.api.client.json.JsonFactory jsonFactory,
        com.google.api.client.http.HttpRequestInitializer httpRequestInitializer) {
      super(
          transport,
          jsonFactory,
          DEFAULT_ROOT_URL,
          DEFAULT_SERVICE_PATH,
          httpRequestInitializer,
          false);
    }

    /** Builds a new instance of {@link ContentApi}. */
    @Override
    public ContentApi build() {
      return new ContentApi(this);
    }

    @Override
    public Builder setRootUrl(String rootUrl) {
      return (Builder) super.setRootUrl(rootUrl);
    }

    @Override
    public Builder setServicePath(String servicePath) {
      return (Builder) super.setServicePath(servicePath);
    }

    @Override
    public Builder setHttpRequestInitializer(com.google.api.client.http.HttpRequestInitializer httpRequestInitializer) {
      return (Builder) super.setHttpRequestInitializer(httpRequestInitializer);
    }

    @Override
    public Builder setApplicationName(String applicationName) {
      return (Builder) super.setApplicationName(applicationName);
    }

    @Override
    public Builder setSuppressPatternChecks(boolean suppressPatternChecks) {
      return (Builder) super.setSuppressPatternChecks(suppressPatternChecks);
    }

    @Override
    public Builder setSuppressRequiredParameterChecks(boolean suppressRequiredParameterChecks) {
      return (Builder) super.setSuppressRequiredParameterChecks(suppressRequiredParameterChecks);
    }

    @Override
    public Builder setSuppressAllChecks(boolean suppressAllChecks) {
      return (Builder) super.setSuppressAllChecks(suppressAllChecks);
    }

    /**
     * Set the {@link ContentApiRequestInitializer}.
     *
     * @since 1.12
     */
    public Builder setContentApiRequestInitializer(
        ContentApiRequestInitializer contentapiRequestInitializer) {
      return (Builder) super.setGoogleClientRequestInitializer(contentapiRequestInitializer);
    }

    @Override
    public Builder setGoogleClientRequestInitializer(
        com.google.api.client.googleapis.services.GoogleClientRequestInitializer googleClientRequestInitializer) {
      return (Builder) super.setGoogleClientRequestInitializer(googleClientRequestInitializer);
    }
  }
}
