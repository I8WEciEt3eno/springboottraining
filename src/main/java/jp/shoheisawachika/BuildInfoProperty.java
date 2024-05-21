package jp.shoheisawachika;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
@ConfigurationProperties(prefix = "build")
public class BuildInfoProperty {
    private final String artifact;
    private final String group;
    private final String name;
    private final String time;
    private final String version;
}