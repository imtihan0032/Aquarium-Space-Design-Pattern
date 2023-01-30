package org.aquarium;

public interface EntityFactory {
    public abstract Entity createFishesEntity(AquariumSpace aquarium, Space space, int fishRandom, int countArapaima, int countMackerel, int countSardine, int countTilapia, int countToman);
    public abstract Entity createCrabsEntity();
    public abstract Entity createSeahorsesEntity();
    public abstract Entity createWreckedShipEntity();
    public abstract Entity createSeaweedsEntity();
    public abstract Entity createBubblesEntity();
}