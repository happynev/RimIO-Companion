package at.happynev.rimio;

import generated.*;
import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableMap;
import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SuppressWarnings("WeakerAccess")
public class PawnInstance {
    public final StringProperty fullName = new SimpleStringProperty();
    public final StringProperty nickName = new SimpleStringProperty();
    public final StringProperty label = new SimpleStringProperty();
    public final IntegerProperty onMap = new SimpleIntegerProperty();
    public final IntegerProperty locationX = new SimpleIntegerProperty();
    public final IntegerProperty locationY = new SimpleIntegerProperty();
    public final BooleanProperty isColonist = new SimpleBooleanProperty();
    public final BooleanProperty isVisitor = new SimpleBooleanProperty();
    public final BooleanProperty isPrisoner = new SimpleBooleanProperty();
    public final BooleanProperty isEnemy = new SimpleBooleanProperty();
    public final BooleanProperty isDrafted = new SimpleBooleanProperty();
    public final BooleanProperty isSelected = new SimpleBooleanProperty();
    public final BooleanProperty isDead = new SimpleBooleanProperty();
    public final BooleanProperty isDowned = new SimpleBooleanProperty();
    public final BooleanProperty isSleeping = new SimpleBooleanProperty();
    public final BooleanProperty isIdle = new SimpleBooleanProperty();
    public final BooleanProperty isMedicalRest = new SimpleBooleanProperty();
    public final BooleanProperty isInMentalState = new SimpleBooleanProperty();
    public final BooleanProperty isInAggroMentalState = new SimpleBooleanProperty();
    public final FloatProperty age = new SimpleFloatProperty();
    public final FloatProperty health = new SimpleFloatProperty();
    public final ObservableList<String> traits = FXCollections.observableArrayList();
    public final ObservableList<SkillData> skills = FXCollections.observableArrayList();
    public final ObservableMap<String, FloatProperty> needs = FXCollections.observableHashMap();
    public final ObservableMap<String, FloatProperty> capacities = FXCollections.observableHashMap();
    public final ObservableList<Hediff> hediffs = FXCollections.observableArrayList();
    public final ObjectProperty<Job> currentJob = new SimpleObjectProperty<>();
    public final ObjectProperty<Image> portrait = new SimpleObjectProperty<>();
    public final IntegerProperty jobTargetAX = new SimpleIntegerProperty();
    public final IntegerProperty jobTargetAY = new SimpleIntegerProperty();
    public final IntegerProperty jobTargetBX = new SimpleIntegerProperty();
    public final IntegerProperty jobTargetBY = new SimpleIntegerProperty();
    public final IntegerProperty jobTargetCX = new SimpleIntegerProperty();
    public final IntegerProperty jobTargetCY = new SimpleIntegerProperty();
    private final String id;
    private byte[] lastPortraitData;

    public PawnInstance(PawnDataType pawndata) {
        id = pawndata.getId();
        System.out.println("created new pawn: " + pawndata.getNickName());
        update(pawndata);
    }

    private PawnInstance getSelf() {
        return this;
    }

    public String getPawnId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PawnInstance that = (PawnInstance) o;

        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    public void update(PawnDataType pawndata) {
        fullName.setValue(pawndata.getFullName());
        nickName.setValue(pawndata.getNickName());
        label.setValue(pawndata.getLabel());

        onMap.setValue(pawndata.getOnMap());
        locationX.setValue(pawndata.getLocation().getX());
        locationY.setValue(pawndata.getLocation().getY());

        isColonist.setValue(pawndata.isColonist());
        isVisitor.setValue(pawndata.isVisitor());
        isPrisoner.setValue(pawndata.isPrisoner());
        isEnemy.setValue(pawndata.isEnemy());
        isDrafted.setValue(pawndata.isDrafted());
        isSelected.setValue(pawndata.isSelected());
        isDead.setValue(pawndata.isDead());
        isDowned.setValue(pawndata.isDowned());
        isSleeping.setValue(pawndata.isSleeping());
        isIdle.setValue(pawndata.isIdle());
        isMedicalRest.setValue(pawndata.isMedicalRest());
        isInMentalState.setValue(pawndata.isInMentalState());
        isInAggroMentalState.setValue(pawndata.isInAggroMentalState());

        age.setValue(pawndata.getAge());
        health.setValue(pawndata.getCurrentHealth());

        List<String> tmpTraits = new ArrayList<>(pawndata.getTraits().getString());
        if (!tmpTraits.equals(traits)) {
            traits.setAll(tmpTraits);
        }
        if (pawndata.isIncludesSkills()) {
            //lets assume skills don't vanish
            for (SkillDataType skilldata : pawndata.getSkillsData().getSkills().getSkillData()) {
                boolean found = false;
                for (SkillData existing : skills) {
                    if (existing.getName().equals(skilldata.getName())) {
                        existing.update(skilldata);
                        found = true;
                    }
                }
                if (!found) {
                    skills.add(new SkillData(skilldata));
                }
            }
        }

        if (pawndata.isIncludesNeeds() && pawndata.getNeedData() != null) {
            for (KeyValuePairType kv : pawndata.getNeedData().getNeeds().getKeyValuePair()) {
                if (needs.containsKey(kv.getKey())) {
                    needs.get(kv.getKey()).setValue(Float.parseFloat(kv.getValue()));
                } else {
                    needs.put(kv.getKey(), new SimpleFloatProperty(Float.parseFloat(kv.getValue())));
                }
            }
        }
        if (pawndata.isIncludesHealth()) {
            List<Hediff> tmpHediffs = new ArrayList<>();
            for (HediffDataType hediffdata : pawndata.getHealthData().getHediffs().getHediffData()) {
                Hediff hediff = new Hediff(hediffdata);
                tmpHediffs.add(hediff);
            }
            hediffs.setAll(tmpHediffs);
            for (KeyValuePairType kv : pawndata.getCapacityData().getCapacities().getKeyValuePair()) {
                if (capacities.containsKey(kv.getKey())) {
                    capacities.get(kv.getKey()).setValue(Float.parseFloat(kv.getValue()));
                } else {
                    capacities.put(kv.getKey(), new SimpleFloatProperty(Float.parseFloat(kv.getValue())));
                }
            }
        }

        if (pawndata.isIncludesJob()) {
            currentJob.set(new Job(pawndata.getJob(), this));
        }

        if (pawndata.isIncludesPortrait() && !Arrays.equals(pawndata.getPortrait(), lastPortraitData)) { //only update on change
            //crop to save some screen space
            Image receivedImage = new Image(new ByteArrayInputStream(pawndata.getPortrait()));
            int offset = (int) (receivedImage.getHeight() * 0.25);
            WritableImage newImage = new WritableImage(receivedImage.getPixelReader(), 0, offset, (int) receivedImage.getWidth(), (int) receivedImage.getHeight() - offset);
            portrait.setValue(newImage);
            lastPortraitData = pawndata.getPortrait();
        }
    }

    public static class SkillData {
        public final StringProperty passion = new SimpleStringProperty();
        public final BooleanProperty enabled = new SimpleBooleanProperty();
        public final IntegerProperty level = new SimpleIntegerProperty();
        public final FloatProperty xpProgress = new SimpleFloatProperty();
        public final FloatProperty totalXp = new SimpleFloatProperty();
        public final FloatProperty currentXp = new SimpleFloatProperty();
        public final FloatProperty levelupXp = new SimpleFloatProperty();
        private final String name;

        public SkillData(SkillDataType skilldata) {
            this.name = skilldata.getName();
            update(skilldata);
        }

        private void update(SkillDataType skilldata) {
            passion.setValue(skilldata.getPassion());
            enabled.setValue(skilldata.isEnabled());
            level.setValue(skilldata.getLevel());
            xpProgress.setValue(skilldata.getXpProgress());
            totalXp.setValue(skilldata.getTotalXp());
            currentXp.setValue(skilldata.getCurrentXp());
            levelupXp.setValue(skilldata.getLevelupXp());
        }

        public String getName() {
            return name;
        }
    }

    public static class Hediff {
        private final String label;
        private final boolean tendable;
        private final boolean tended;
        private final float bleedRate;
        private final float pain;
        private final String location;
        private final float healthPercentImpact;
        private final boolean permanent;

        public Hediff(HediffDataType hediffdata) {
            label = hediffdata.getLabel();
            tendable = hediffdata.isTendable();
            tended = hediffdata.isTended();
            bleedRate = hediffdata.getBleedRate();
            pain = hediffdata.getPain();
            if (hediffdata.getLocation() != null) {
                location = hediffdata.getLocation();
            } else {
                location = "none";
            }
            healthPercentImpact = hediffdata.getHealthPercentImpact();
            permanent = hediffdata.isPermanent();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Hediff hediff = (Hediff) o;

            if (tendable != hediff.tendable) return false;
            if (tended != hediff.tended) return false;
            if (Float.compare(hediff.bleedRate, bleedRate) != 0) return false;
            if (Float.compare(hediff.pain, pain) != 0) return false;
            if (Float.compare(hediff.healthPercentImpact, healthPercentImpact) != 0) return false;
            if (permanent != hediff.permanent) return false;
            if (label != null ? !label.equals(hediff.label) : hediff.label != null) return false;
            return location != null ? location.equals(hediff.location) : hediff.location == null;
        }

        @Override
        public int hashCode() {
            int result = label != null ? label.hashCode() : 0;
            result = 31 * result + (tendable ? 1 : 0);
            result = 31 * result + (tended ? 1 : 0);
            result = 31 * result + (bleedRate != +0.0f ? Float.floatToIntBits(bleedRate) : 0);
            result = 31 * result + (pain != +0.0f ? Float.floatToIntBits(pain) : 0);
            result = 31 * result + (location != null ? location.hashCode() : 0);
            result = 31 * result + (healthPercentImpact != +0.0f ? Float.floatToIntBits(healthPercentImpact) : 0);
            result = 31 * result + (permanent ? 1 : 0);
            return result;
        }
    }

    public static class Job {
        private final String label;
        private final Target targetA;
        private final Target targetB;
        private final Target targetC;
        private final PawnInstance owner;

        public Job(JobType jobdata, PawnInstance owner) {
            this.owner = owner;
            if (jobdata == null) {
                label = "None";
                targetA = null;
                targetB = null;
                targetC = null;
            } else {
                label = jobdata.getName().replaceAll("^\\?.*", "?"); //leftover c# debuginfo;
                if (jobdata.getTargetA() != null) {
                    targetA = new Target(jobdata.getTargetA());
                    owner.jobTargetAX.set(targetA.locationX);
                    owner.jobTargetAY.set(targetA.locationY);
                } else {
                    targetA = null;
                    owner.jobTargetAX.set(-1);
                    owner.jobTargetAY.set(-1);
                }
                if (jobdata.getTargetB() != null) {
                    targetB = new Target(jobdata.getTargetB());
                    owner.jobTargetBX.set(targetB.locationX);
                    owner.jobTargetBY.set(targetB.locationY);
                } else {
                    targetB = null;
                    owner.jobTargetBX.set(-1);
                    owner.jobTargetBY.set(-1);
                }
                if (jobdata.getTargetC() != null) {
                    targetC = new Target(jobdata.getTargetC());
                    owner.jobTargetCX.set(targetC.locationX);
                    owner.jobTargetCY.set(targetC.locationY);
                } else {
                    targetC = null;
                    owner.jobTargetCX.set(-1);
                    owner.jobTargetCY.set(-1);
                }
            }
        }

        public String getLabel() {
            return label;
        }

        public Target getTargetA() {
            return targetA;
        }

        public Target getTargetB() {
            return targetB;
        }

        public Target getTargetC() {
            return targetC;
        }

        public boolean hasTargetA() {
            return targetA != null;
        }

        public boolean hasTargetB() {
            return targetB != null;
        }

        public boolean hasTargetC() {
            return targetC != null;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Job job = (Job) o;

            if (!label.equals(job.label)) return false;
            if (targetA != null ? !targetA.equals(job.targetA) : job.targetA != null) return false;
            if (targetB != null ? !targetB.equals(job.targetB) : job.targetB != null) return false;
            return targetC != null ? targetC.equals(job.targetC) : job.targetC == null;
        }

        @Override
        public int hashCode() {
            int result = label.hashCode();
            result = 31 * result + (targetA != null ? targetA.hashCode() : 0);
            result = 31 * result + (targetB != null ? targetB.hashCode() : 0);
            result = 31 * result + (targetC != null ? targetC.hashCode() : 0);
            return result;
        }

        public String getFullText() {
            String ret = label.replaceAll("\\.$", ""); //for some reason, JobDef includes a trailing .
            if (hasTargetA()) {
                String repltext = targetA.name;
                ret = ret.replaceAll("TargetA", repltext);
                double distance = targetA.distanceTo(owner);
                if (distance > 1) {
                    ret += String.format(" at %d/%d (%.1f tiles away)", targetA.locationX, targetA.locationY, distance);
                }
            }
            if (hasTargetB()) {
                ret = ret.replaceAll("TargetB", targetB.name); //never seen this?
                if (targetB.hasLocation() && targetA.hasLocation()) {
                    double distance = targetB.distanceTo(targetA);
                    if (distance > 1) {
                        ret += String.format(" to %d/%d (%.1f tiles further)", targetB.locationX, targetB.locationY, distance);
                    }
                }
            }
            if (hasTargetC()) {
                ret = ret.replaceAll("TargetC", targetB.name); //never seen this?
                if (targetC.hasLocation() && targetB.hasLocation()) {
                    double distance = targetC.distanceTo(targetB);
                    if (distance > 1) {
                        ret += String.format(" and afterwards to %d/%d (%.1f tiles more)", targetC.locationX, targetC.locationY, distance);
                    }
                }
            }
            return ret;
        }

        public static class Target {
            private final String name;
            private final int locationX;
            private final int locationY;

            public Target(TargetType targetData) {
                name = targetData.getName();
                if (targetData.getLocation() != null) {
                    locationX = targetData.getLocation().getX();
                    locationY = targetData.getLocation().getY();
                } else {
                    locationX = -1;
                    locationY = -1;
                }
            }

            public double distanceTo(Target t) {
                if (hasLocation() && t.hasLocation()) {
                    return Utilities.calculateDistance(locationX, locationY, t.locationX, t.locationY);
                } else {
                    return 0;
                }
            }

            public double distanceTo(PawnInstance p) {
                if (hasLocation() && p.locationX.get() > -1) {
                    return Utilities.calculateDistance(locationX, locationY, p.locationX.get(), p.locationY.get());
                } else {
                    return 0;
                }
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;

                Target target = (Target) o;

                if (locationX != target.locationX) return false;
                if (locationY != target.locationY) return false;
                return name.equals(target.name);
            }

            @Override
            public int hashCode() {
                int result = name.hashCode();
                result = 31 * result + locationX;
                result = 31 * result + locationY;
                return result;
            }

            public String getName() {
                return name;
            }

            public boolean hasLocation() {
                return locationX > -1;
            }

            public int getLocationX() {
                return locationX;
            }

            public int getLocationY() {
                return locationY;
            }
        }
    }
}
