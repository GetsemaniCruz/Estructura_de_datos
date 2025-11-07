public class JobCustom {

    private String id;

    public JobCustom() {
    }

    public JobCustom(String id) {
        this.id=id;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    @Override
    public String toString() {
        return "JobCustom [id=" + id + "]";
    }
    
}
