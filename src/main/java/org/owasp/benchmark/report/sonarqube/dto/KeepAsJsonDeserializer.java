package org.owasp.benchmark.report.sonarqube.dto;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.core.TreeNode;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/** <a href="https://stackoverflow.com/a/24085100">Credits to Roy Truelove</a> */
public class KeepAsJsonDeserializer extends JsonDeserializer<List<String>> {

    @Override
    public List<String> deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
        ObjectCodec codec = jp.getCodec();
        TreeNode entries = codec.readTree(jp);
        List<String> result = new ArrayList<>();

        for (int i = 0; i < entries.size(); i++) {
            result.add(codec.readTree(codec.treeAsTokens(entries.get(i))).toString());
        }

        return result;
    }
}
