package mycode.xin.com.seven_wying.mvp;


import dagger.Component;
import mycode.xin.com.seven_wying.activity.MainActivity;
import mycode.xin.com.seven_wying.fragmetns.ChoicenessFragment;
import mycode.xin.com.seven_wying.fragmetns.DiscoverFragment;
import mycode.xin.com.seven_wying.fragmetns.DiscussFragment;
import mycode.xin.com.seven_wying.fragmetns.IntroFragment;
import mycode.xin.com.seven_wying.fragmetns.MineFragment;
import mycode.xin.com.seven_wying.fragmetns.SpecialFragment;

/**
 * date:2017/12/12  23:40
 * author:Mr.XIn💕
 */
@Component(modules = IModule.class)
public interface IComponent {

    void inject(MainActivity mainActivity);

    void injectChoiceness(ChoicenessFragment choicenessFragment);

    void injectSpecial(SpecialFragment specialFragment);

    void injectDiscover(DiscoverFragment discoverFragment);

    void injectMine(MineFragment mineFragment);

    void injectIntro(IntroFragment introFragment);

    void injectDiscuss(DiscussFragment discoverFragment);


}
