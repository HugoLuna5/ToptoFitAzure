package lunainc.com.mx.toptofitazureapp.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Prediction implements Serializable {

    @Expose
    @SerializedName("probability")
    Double probability;

    @Expose
    @SerializedName("tagId")
    String tagId;

    @Expose
    @SerializedName("tagName")
    String tagName;

    public Prediction() {
    }

    public Prediction(Double probability, String tagId, String tagName) {
        this.probability = probability;
        this.tagId = tagId;
        this.tagName = tagName;
    }

    public Double getProbability() {
        return probability;
    }

    public void setProbability(Double probability) {
        this.probability = probability;
    }

    public String getTagId() {
        return tagId;
    }

    public void setTagId(String tagId) {
        this.tagId = tagId;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }
}
