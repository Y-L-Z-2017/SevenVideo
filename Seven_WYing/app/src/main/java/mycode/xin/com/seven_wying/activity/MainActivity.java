package mycode.xin.com.seven_wying.activity;

import android.support.v4.app.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.jaeger.library.StatusBarUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import mycode.xin.com.seven_wying.R;
import mycode.xin.com.seven_wying.fragmetns.ChoicenessFragment;
import mycode.xin.com.seven_wying.fragmetns.DiscoverFragment;
import mycode.xin.com.seven_wying.fragmetns.MineFragment;
import mycode.xin.com.seven_wying.fragmetns.SpecialFragment;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.fragmets)
    FrameLayout mFragmets;
    @BindView(R.id.bnb)
    BottomNavigationBar mBnb;
    private FragmentManager manager;
    private Fragment fm;
    private ChoicenessFragment mChoicenessFragment;
    private DiscoverFragment mDiscoverFragment;
    private MineFragment mMineFragment;
    private SpecialFragment mSpecialFragment;
    private FragmentTransaction mTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StatusBarUtil.setTranslucent(MainActivity.this);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mChoicenessFragment = new ChoicenessFragment();
        mDiscoverFragment = new DiscoverFragment();
        mMineFragment = new MineFragment();
        mSpecialFragment = new SpecialFragment();
        if (mChoicenessFragment == null) {
            mChoicenessFragment = new ChoicenessFragment();
        }
        changeFragment(mChoicenessFragment);

        mBnb.setMode(BottomNavigationBar.MODE_FIXED)
                .setActiveColor("#FFFF0000")
                .setInActiveColor("#B3B3B3")
                .addItem(new BottomNavigationItem(R.drawable.found_select, "精选")
                        .setInactiveIconResource(R.drawable.found))
                .addItem(new BottomNavigationItem(R.drawable.special_select, "专题")
                        .setInactiveIconResource(R.drawable.special))
                .addItem(new BottomNavigationItem(R.drawable.fancy_select, "发现")
                        .setInactiveIconResource(R.drawable.fancy))
                .addItem(new BottomNavigationItem(R.drawable.my_select, "我的")
                        .setInactiveIconResource(R.drawable.my))
                .initialise();
        mBnb.setTabSelectedListener(new BottomNavigationBar.OnTabSelectedListener() {
            @Override
            public void onTabSelected(int position) {
                switch (position) {
                    case 0:
                        if (mChoicenessFragment == null) {
                            mChoicenessFragment = new ChoicenessFragment();
                        }
                        changeFragment(mChoicenessFragment);
                        break;
                    case 1:
                        if (mSpecialFragment == null) {
                            mSpecialFragment = new SpecialFragment();
                        }
                        changeFragment(mSpecialFragment);
                        break;
                    case 2:
                        if (mDiscoverFragment == null) {
                            mDiscoverFragment = new DiscoverFragment();
                        }
                        changeFragment(mDiscoverFragment);
                        break;
                    case 3:
                        if (mMineFragment == null) {
                            mMineFragment = new MineFragment();
                        }
                        changeFragment(mMineFragment);
                        break;
                }
            }

            @Override
            public void onTabUnselected(int position) {

            }

            @Override
            public void onTabReselected(int position) {

            }
        });
    }

    public void changeFragment(Fragment ment) {

        manager = getSupportFragmentManager();
        mTransaction = manager.beginTransaction();
        if (fm != null) {
            mTransaction.hide(fm);
        }
        // isAdded:是否被添加过 被添加过 is true 反之
        if (!ment.isAdded()) {
            // 调用replace 添加fragment
            mTransaction.add(R.id.fragmets, ment);
        } else {
            // 显示出来
            mTransaction.show(ment);
        }
        mTransaction.commit();

        // 记录当前的Fragment
        fm = ment;
    }


}
