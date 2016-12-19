package template;

import java.util.Random;
import java.util.function.Consumer;

/**
 * Template Pattern :
 * The problem is that we cannot garantee that every time our Resource is used will be disposed correctly following this pattern.
 * We don’t want to risk the possibility of the Resource being misused: we would like to provide an API forcing the clients
 * of the Resource object to always dispose it.
 */

public class Resource {
    public Resource() {
        System.out.println("Resource created");
    }

    public void useResource() {
        riskyOperation();
        System.out.println("Resource used");
    }

    public void employResource() {
        riskyOperation();
        System.out.println("Resource employed");
    }

    public void dispose() {
        System.out.println("Resource disposed");
    }

    private void riskyOperation() {
        if ( new Random().nextInt( 10 ) == 0) {
            throw new RuntimeException();
        }
    }

    public static void withResource(Consumer<Resource> consumer) {
        Resource resource = new Resource();
        try {
            consumer.accept( resource );
        } finally {
            resource.dispose();
        }
    }
}