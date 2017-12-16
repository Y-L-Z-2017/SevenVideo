package mycode.xin.com.seven_wying.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import io.reactivex.disposables.Disposable;

/**
 * date:2017/12/12  20:33
 * author:Mr.XIn💕
 */


public abstract class BaseFragment<V, T extends BasePresenter<V>> extends Fragment {
    T presenter;
    View mView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (mView == null) {
             mView = inflater.inflate(setLayout(), container, false);
            bridge();
            presenter = getPresenter();
        }
        if (presenter != null) {
            Log.e("xx","有");
            presenter.attch((V) this);
        }else {
            Log.e("xx","无");
        }

        initView(mView);
        logic();
        return mView;
    }

    protected abstract int setLayout();

    protected abstract void bridge();

    protected abstract T getPresenter();

    protected abstract void initView(View mview);

    protected abstract void logic();

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e("xx","ji");
        if(presenter!=null){
            presenter.disAttch();
        }else {
            Log.e("xx","空");
        }

    }
}
