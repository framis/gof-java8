package singleton;

/**
 * See Joshua Bloch's Effective Java.
 * "This approach is functionally equivalent to the public field approach, except that it
 * is more concise, provides the serialization machinery for free, and provides an
 * ironclad guarantee against multiple instantiation, even in the face of sophisticated
 * serialization or reflection attacks."
 */
public enum Elvis {
    INSTANCE;
    public void leaveTheBuilding() {
        System.out.println("Elvis is leaving the building");
    }
}
