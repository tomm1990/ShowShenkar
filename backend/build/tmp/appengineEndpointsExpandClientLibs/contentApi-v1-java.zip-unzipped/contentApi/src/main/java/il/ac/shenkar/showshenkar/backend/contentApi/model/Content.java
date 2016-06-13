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
 * on 2016-06-13 at 16:50:01 UTC 
 * Modify at your own risk.
 */

package il.ac.shenkar.showshenkar.backend.contentApi.model;

/**
 * Model definition for Content.
 *
 * <p> This is the Java data model class that specifies how to parse/serialize into the JSON that is
 * transmitted over HTTP when working with the contentApi. For a detailed explanation see:
 * <a href="https://developers.google.com/api-client-library/java/google-http-java-client/json">https://developers.google.com/api-client-library/java/google-http-java-client/json</a>
 * </p>
 *
 * @author Google, Inc.
 */
@SuppressWarnings("javadoc")
public final class Content extends com.google.api.client.json.GenericJson {

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private com.google.api.client.util.DateTime created;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key @com.google.api.client.json.JsonString
  private java.lang.Long id;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private Info info;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private Location location;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private Media media;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private com.google.api.client.util.DateTime modified;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.String type;

  /**
   * @return value or {@code null} for none
   */
  public com.google.api.client.util.DateTime getCreated() {
    return created;
  }

  /**
   * @param created created or {@code null} for none
   */
  public Content setCreated(com.google.api.client.util.DateTime created) {
    this.created = created;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.Long getId() {
    return id;
  }

  /**
   * @param id id or {@code null} for none
   */
  public Content setId(java.lang.Long id) {
    this.id = id;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public Info getInfo() {
    return info;
  }

  /**
   * @param info info or {@code null} for none
   */
  public Content setInfo(Info info) {
    this.info = info;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public Location getLocation() {
    return location;
  }

  /**
   * @param location location or {@code null} for none
   */
  public Content setLocation(Location location) {
    this.location = location;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public Media getMedia() {
    return media;
  }

  /**
   * @param media media or {@code null} for none
   */
  public Content setMedia(Media media) {
    this.media = media;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public com.google.api.client.util.DateTime getModified() {
    return modified;
  }

  /**
   * @param modified modified or {@code null} for none
   */
  public Content setModified(com.google.api.client.util.DateTime modified) {
    this.modified = modified;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.String getType() {
    return type;
  }

  /**
   * @param type type or {@code null} for none
   */
  public Content setType(java.lang.String type) {
    this.type = type;
    return this;
  }

  @Override
  public Content set(String fieldName, Object value) {
    return (Content) super.set(fieldName, value);
  }

  @Override
  public Content clone() {
    return (Content) super.clone();
  }

}
