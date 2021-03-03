package lunainc.com.mx.toptofitazureapp.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

public class ResponseAzure implements Serializable {

    @Expose
    @SerializedName("id")
    String id;

    @Expose
    @SerializedName("project")
    String project;

    @Expose
    @SerializedName("iteration")
    String iteration;

    @Expose
    @SerializedName("created")
    String created;

    @Expose
    @SerializedName("predictions")
    ArrayList<Prediction> predictions;

    public ResponseAzure() {
    }

    public ResponseAzure(String id, String project, String iteration, String created, ArrayList<Prediction> predictions) {
        this.id = id;
        this.project = project;
        this.iteration = iteration;
        this.created = created;
        this.predictions = predictions;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public String getIteration() {
        return iteration;
    }

    public void setIteration(String iteration) {
        this.iteration = iteration;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public ArrayList<Prediction> getPredictions() {
        return predictions;
    }

    public void setPredictions(ArrayList<Prediction> predictions) {
        this.predictions = predictions;
    }
}
