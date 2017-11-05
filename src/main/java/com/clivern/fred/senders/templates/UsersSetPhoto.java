/*
 * Copyright (C) 2017 A.F <http://clivern.com>
 *
 * Licensed under the MIT License; you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * https://github.com/Clivern/Fred/blob/master/LICENSE
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package com.clivern.fred.senders.templates;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import com.clivern.fred.configs.Basic;
import com.clivern.fred.contract.templates.BasicTemplate;

/**
 * Users Set Photo Template Class
 *
 * It Set the user profile photo.
 *
 * It allows the user to set their profile image. The caller can pass image data via image.
 * Providing a "crop box" with crop_x, crop_y, and crop_w is optional. Otherwise, the whole image will be used.
 * If cropping instructions are not specified and the source image is not square, the image will be letterboxed,
 * just like your favorite old laserdiscs.
 * Please limit your images to a maximum size of 1024 by 1024 pixels. 512x512 pixels is the minimum.
 *
 * Supported token types: user
 * Expected scopes: users.profile:write, post
 *
 * <a href="https://api.slack.com/methods/users.setPhoto">For More Info</a>
 *
 * @author A.F
 * @since 1.0.0
 */
public class UsersSetPhoto extends BasicTemplate {

    protected String url = Basic.methodURL(Basic.usersSetPhotoMethod);
    protected String token;
    protected String image;
    protected Integer cropW;
    protected Integer cropX;
    protected Integer cropY;

    /**
     * Set Token
     *
     * @param token
     */
    public void setToken(String token)
    {
        this.token = token;
    }

    /**
     * Set Image
     *
     * @param image
     */
    public void setImage(String image)
    {
        this.image = image;
    }

    /**
     * Set Crop W
     *
     * @param cropW
     */
    public void setCropW(Integer cropW)
    {
        this.cropW = cropW;
    }

    /**
     * Set Crop X
     *
     * @param cropX
     */
    public void setCropX(Integer cropX)
    {
        this.cropX = cropX;
    }

    /**
     * Set Crop Y
     *
     * @param cropY
     */
    public void setCropY(Integer cropY)
    {
        this.cropY = cropY;
    }

    /**
     * Get Token
     *
     * @return String
     */
    public String getToken()
    {
        return this.token;
    }

    /**
     * Get Image
     *
     * @return String
     */
    public String getImage()
    {
        return this.image;
    }

    /**
     * Get Crop W
     *
     * @return Integer
     */
    public Integer getCropW()
    {
        return this.cropW;
    }

    /**
     * Get Crop X
     *
     * @return Integer
     */
    public Integer getCropX()
    {
        return this.cropX;
    }

    /**
     * Get Crop Y
     *
     * @return Integer
     */
    public Integer getCropY()
    {
        return this.cropY;
    }

    /**
     * Build Message Body
     */
    public String build()
    {
        if( this.token.isEmpty() || this.image.isEmpty() ){
            return "";
        }

        if( !this.token.isEmpty() ){
            this.body += "token=" + this.token;
        }

        if( !this.image.isEmpty() ){
            this.body += "&image=" + this.image;
        }

        if( this.cropW != null ){
            this.body += "&crop_w=" + this.cropW;
        }

        if( this.cropX != null ){
            this.body += "&crop_x=" + this.cropX;
        }

        if( this.cropY != null ){
            this.body += "&crop_y=" + this.cropY;
        }

        return this.body;
    }
}