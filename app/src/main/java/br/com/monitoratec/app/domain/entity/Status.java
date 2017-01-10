package br.com.monitoratec.app.domain.entity;

import android.graphics.Color;

import com.google.gson.annotations.SerializedName;

/**
 * Entidade da API GitHub Status.
 *
 * @see <a href="https://status.github.com/api/last-message.json">Last Message</a>
 *
 * Created by falvojr on 1/9/17.
 */
public class Status {
    public Type status;
    public String body;
    public String created_on;

    public enum Type{

        @SerializedName("good")
        GOOD(Color.green(1)),
        @SerializedName("minor")
        MINOR(Color.green(1)),
        @SerializedName("major")
        MAJOR(Color.green(1));

        private int colorId;

        Type(int id) {
            this.colorId =id;
        }

        public int getColorId(){
            return colorId;
        }
    }

}
