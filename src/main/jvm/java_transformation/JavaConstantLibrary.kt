package java_transformation

class JavaConstantLibrary {

    object lib {
        const val javaMemoryObjectClasses = """
class AadlMemoryObject <T> {
    private T payload = null;
    private T previous = null;
    private boolean hasPayload = false;
    private boolean hasPrevious = false;

    public void set(T payload) {
        this.previous = this.payload;
        this.payload = payload;
        if (hasPayload) {
            hasPrevious = true;
        }
        hasPayload = true;
    }

    public void set(T initialValue, T payload) {
        if (this.payload == null) {
            set(initialValue);
        } else {
            set(payload);
        }
    }

    public T get() {
        if (!hasPayload) {
            throw new RuntimeException("Aadl variable never set!");
        } else {
            return payload;
        }
    }

    public T previous() {
        if (!hasPrevious) {
            throw new RuntimeException("Aadl varible never set!");
        } else {
            return previous;
        }
    }

    public boolean hasPrevious() {
        return hasPrevious;
    }
}

class AadlUtil {
    public static <T> T pre(AadlMemoryObject<T> aadlField) {
        return aadlField.previous();
    }
}
"""
    }
}
