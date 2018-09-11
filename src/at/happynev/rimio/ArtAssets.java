package at.happynev.rimio;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ArtAssets {

    public static final int SMALL_ICON_SIZE = 20;
    public static final int BIG_ICON_SIZE = 64;
    public static final Image BANDAGED = new Image(ClassLoader.getSystemClassLoader().getResourceAsStream("icons/BandageWell.png"));
    public static final Image BLEEDING = new Image(ClassLoader.getSystemClassLoader().getResourceAsStream("icons/Bleeding.png"));
    public static final Image MEDICALREST = new Image(ClassLoader.getSystemClassLoader().getResourceAsStream("icons/MedicalRest.png"));
    public static final Image MENTAL_AGGRO = new Image(ClassLoader.getSystemClassLoader().getResourceAsStream("icons/MentalStateAggro.png"));
    public static final Image MENTAL_NONAGGRO = new Image(ClassLoader.getSystemClassLoader().getResourceAsStream("icons/MentalStateNonAggro.png"));
    public static final Image PASSIONMAJOR = new Image(ClassLoader.getSystemClassLoader().getResourceAsStream("icons/PassionMajor.png"));
    public static final Image PASSIONMINOR = new Image(ClassLoader.getSystemClassLoader().getResourceAsStream("icons/PassionMinor.png"));
    public static final Image SLEEPING = new Image(ClassLoader.getSystemClassLoader().getResourceAsStream("icons/Sleeping.png"));
    public static final Image NEEDTENDING = new Image(ClassLoader.getSystemClassLoader().getResourceAsStream("icons/TendedNeed.png"));
    public static final Image TENDED = new Image(ClassLoader.getSystemClassLoader().getResourceAsStream("icons/TendedWell.png"));
    public static final Image DEAD = new Image(ClassLoader.getSystemClassLoader().getResourceAsStream("icons/DeadColonist.png"));
    public static final Image SKULL = new Image(ClassLoader.getSystemClassLoader().getResourceAsStream("icons/Skull.png"));
    public static final Image CHECK_ON = new Image(ClassLoader.getSystemClassLoader().getResourceAsStream("icons/CheckOn.png"));
    public static final Image CHECK_OFF = new Image(ClassLoader.getSystemClassLoader().getResourceAsStream("icons/CheckOff.png"));
    public static final Image CHECK_PARTIAL = new Image(ClassLoader.getSystemClassLoader().getResourceAsStream("icons/CheckPartial.png"));
    public static final Image OPTION_ON = new Image(ClassLoader.getSystemClassLoader().getResourceAsStream("icons/RadioButOn.png"));
    public static final Image OPTION_OFF = new Image(ClassLoader.getSystemClassLoader().getResourceAsStream("icons/RadioButOff.png"));
    public static final Image IDLE = new Image(ClassLoader.getSystemClassLoader().getResourceAsStream("icons/Idle.png"));
    public static final Image DRAFT = new Image(ClassLoader.getSystemClassLoader().getResourceAsStream("icons/Draft.png"));
    public static final Image COMPONENT = new Image(ClassLoader.getSystemClassLoader().getResourceAsStream("icons/Component.png"));

    //from "Moody" Mod by Giant Space Hamster
    /*public static final Image SKILL_ANIMALS = new Image(ClassLoader.getSystemClassLoader().getResourceAsStream("icons/moody/Skills/animals.png"));
    public static final Image SKILL_ARTISTIC = new Image(ClassLoader.getSystemClassLoader().getResourceAsStream("icons/moody/Skills/artistic.png"));
    public static final Image SKILL_CONSTRUCTION = new Image(ClassLoader.getSystemClassLoader().getResourceAsStream("icons/moody/Skills/construction.png"));
    public static final Image SKILL_COOKING = new Image(ClassLoader.getSystemClassLoader().getResourceAsStream("icons/moody/Skills/cooking.png"));
    public static final Image SKILL_CRAFTING = new Image(ClassLoader.getSystemClassLoader().getResourceAsStream("icons/moody/Skills/crafting.png"));
    public static final Image SKILL_GROWING = new Image(ClassLoader.getSystemClassLoader().getResourceAsStream("icons/moody/Skills/growing.png"));
    public static final Image SKILL_INTELLECTUAL = new Image(ClassLoader.getSystemClassLoader().getResourceAsStream("icons/moody/Skills/intellectual.png"));
    public static final Image SKILL_MEDICINE = new Image(ClassLoader.getSystemClassLoader().getResourceAsStream("icons/moody/Skills/medicine.png"));
    public static final Image SKILL_MELEE = new Image(ClassLoader.getSystemClassLoader().getResourceAsStream("icons/moody/Skills/melee.png"));
    public static final Image SKILL_MINING = new Image(ClassLoader.getSystemClassLoader().getResourceAsStream("icons/moody/Skills/mining.png"));
    public static final Image SKILL_SHOOTING = new Image(ClassLoader.getSystemClassLoader().getResourceAsStream("icons/moody/Skills/shooting.png"));
    public static final Image SKILL_SOCIAL = new Image(ClassLoader.getSystemClassLoader().getResourceAsStream("icons/moody/Skills/social.png"));
*/
    public static ImageView getImageViewDefault(Image i) {
        ImageView iv = new ImageView(i);
        iv.setSmooth(true);
        iv.setPreserveRatio(true);
        return iv;
    }
}
