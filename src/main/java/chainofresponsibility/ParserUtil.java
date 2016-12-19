package chainofresponsibility;

import java.util.Optional;

/**
 * The Chain Of Responsibility Pattern consists in creating a sequence of objects that are designed to process an input.
 * Each object in the chain could, or could not, be able to process a specific input.
 * If a processing object has been designed for the input at hand it will do so,
 * otherwise it will pass the input down to the next object of the chain.
 * If the last object of the chain also isn't able to process a given input,
 * the chain will fail silently, or more commonly, will notify the user of the failure with an Exception.
 */
public class ParserUtil {
    public static Optional<String> parseText(File file) {
        return file.getType() == File.Type.TEXT ?
                Optional.of("Text file: " + file.getContent()) :
                Optional.empty();
    }

    public static Optional<String> parseAudio(File file) {
        return file.getType() == File.Type.AUDIO ?
                Optional.of("Audio file: " + file.getContent()) :
                Optional.empty();
    }

    public static Optional<String> parseVideo(File file) {
        return file.getType() == File.Type.VIDEO ?
                Optional.of("Video file: " + file.getContent()) :
                Optional.empty();
    }
}
