package br.com.caseItau.domain.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmailClient {
    public String to;
    public String subject;
    public String body;
}
