package MoonHalo.FlameApi;

import MoonHalo.FlameApi.Event.Impl.AnnotateEventBus;
import MoonHalo.Square.Square;

import java.util.ArrayList;
import java.util.List;

import static MoonHalo.Square.Utils.ClassUtil.getClasses;

public class FlameCore {
    public static AnnotateEventBus eventBus = new AnnotateEventBus();
    public static List<FlameMod> flameModList = new ArrayList<>();
    public static void load(){
        for (Class<?> clz:getClasses("MoonHalo")){

            Square.logger.info(clz.getName());
            if(clz.getSuperclass() == FlameMod.class){
                try {
                    flameModList.add((FlameMod) clz.newInstance());
                }catch (Exception e){

                }
            }
        }
    }
    public static void init(){
        flameModList.forEach(FlameMod::Modinit);
    }
}
