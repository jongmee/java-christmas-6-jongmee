package christmas.view.response;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Response {
    protected static final String NONE = "없음";

    protected Response() {}

    protected List<String> convertMapToMessage(final Map<?, Integer> map, final String FORMAT) {
        List<String> message = new ArrayList<>();
        for(Map.Entry<?, Integer> entry : map.entrySet()) {
            String line = String.format(FORMAT, entry.getKey().toString(), entry.getValue());
            message.add(line);
        }
        return message;
    }

    protected List<String> checkEmptyList(final List<String> message) {
        if(message.size() == 0) {
            message.add(NONE);
        }
        return message;
    }
}
