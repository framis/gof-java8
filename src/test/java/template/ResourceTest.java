package template;

import org.junit.Test;

public class ResourceTest {
    @Test
    public void templatePatternSample() {
        Resource.withResource(Resource::useResource);
        Resource.withResource(Resource::employResource);
    }
}
