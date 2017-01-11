package br.com.monitoratec.app.domain.entity;

import android.graphics.Color;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

import br.com.monitoratec.app.R;

/**
 * Entidade da API GitHub GitHubStatus.
 *
 * @see <a href="https://status.github.com/api/last-message.json">Last Message</a>
 *
 * Created by falvojr on 1/9/17.
 */
public class GitHubStatus {
    public Type status;
    public String body;
    public Date created_on;

    public enum Type{

        @SerializedName("good")
        GOOD(R.color.colorGood),
        @SerializedName("minor")
        MINOR(R.color.colorMinor),
        @SerializedName("major")
        MAJOR(R.color.colorMajor);

        private int colorId;

        Type(int id) {
            this.colorId =id;
        }

        public int getColorId(){
            return colorId;
        }
    }

}
