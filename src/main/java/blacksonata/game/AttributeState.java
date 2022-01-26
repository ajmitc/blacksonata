package blacksonata.game;

public enum AttributeState {
    SOLID,    // Player is not sure
    FADED,    // Player is sure this attribute does NOT apply to dark lady
    MATCH     // Player believes this attribute is on the dark lady
}
