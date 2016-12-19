package chainofresponsibility;

import org.junit.Test;

import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Stream;

public class FileParserTest {
    @Test
    public void sampleChainOfResponsibility() {
        File file = new File( File.Type.AUDIO, "Dream Theater  - The Astonishing" );

        String result = Stream.<Function<File,
                    Optional<String>>>of(ParserUtil::parseText, ParserUtil::parseAudio, ParserUtil::parseVideo)
                .map(f -> f.apply( file )) // Here the Java compiler requires a small help: it is not able to figure what type of objects we're putting in the Stream, so we have to explicitly state this.
                .filter(Optional::isPresent) // Now we need to find the first Optional in the resulting Stream that is not empty so we filter only the Optionals that are present
                .findFirst()
                .flatMap( Function.identity() ) // Calling findFirst() on a Stream of Optional has a minor drawback: since it wraps the result in an Optional (because the Stream could be empty and in that case it will return an Optional.empty()) this time the result will be a Optional<Optional>. We need to flatten this doubly nested Optional in a single level one and to achieve this is enough to call flatMap passing a Function.identity()
                .orElseThrow( () -> new RuntimeException( "Unknown file: " + file ) );
    }
}
