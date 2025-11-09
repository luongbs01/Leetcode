import java.util.HashMap;
import java.util.Map;

/**
 * Description: https://leetcode.com/problems/encode-and-decode-tinyurl/
 */

public class EncodeAndDecodeTinyURL {

    public class Codec {

        Map<String, String> hashmap = new HashMap<>();
        int index = 0;

        // Encodes a URL to a shortened URL.
        public String encode(String longUrl) {
            String key = String.valueOf(index);
            hashmap.put(key, longUrl);
            index++;
            return key;
        }

        // Decodes a shortened URL to its original URL.
        public String decode(String shortUrl) {
            return hashmap.get(shortUrl);
        }
    }
}
