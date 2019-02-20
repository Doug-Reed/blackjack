package blackjack.action;

import org.json.JSONObject;

public interface DealerScript {
    public void deal();

    public void setScript(JSONObject script);
}