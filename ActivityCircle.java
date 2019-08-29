package yaoxudong.textapplication;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import yaoxudong.textapplication.view.YuanHuanView;

public class ActivityCircle extends Activity {

    @BindView(R.id.edittext)
    EditText mEdittext;
    @BindView(R.id.button)
    Button mButton;
    @BindView(R.id.yuanhuan)
    YuanHuanView mYuanhuan;
    private Unbinder mBind;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.yuanhuan);
        mBind = ButterKnife.bind(this);
    }

    @OnClick(R.id.button)
    public void onViewClicked() {
        try{
            String s = mEdittext.getText().toString();
            if(TextUtils.isEmpty(s)){
                return;
            }else{
                String[] split = s.split("-");
                int[] ints = new int[split.length];
                for(int i=0;i<split.length;i++){
                    ints[i]=Integer.valueOf(split[i]);
                }
                mYuanhuan.setYuanHuanData(ints);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
