package view;

import model.Position;

public abstract class DecorFactory {
    public static SpriteDecor create(Position position, int kind) {
        switch (kind) {
            case World.DUST:
                return new SpriteDust(position);
            case World.ROCK:
                return new SpriteRock(position);
            default:
                return null;
        }
    }
}
