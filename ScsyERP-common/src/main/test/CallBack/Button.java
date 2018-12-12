package CallBack;

public class Button {
    private String name;

    public Button(String name) {
        this.name = name;
    }

    public void OnClick(OnClickListener clickListener){
        System.out.println("In Button-OnCall begin");
        clickListener.clickCallBack(name+"Button");
        System.out.println("In Button-OnCall end");
    }
}
