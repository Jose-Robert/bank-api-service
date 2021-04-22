package br.com.github.sistemabancario.infrastructure.builder;

public class MessageBuilder {

    private StringBuilder message = new StringBuilder();

    public MessageBuilder addLine(String line) {
        message.append(line);
        addBlankLine();
        return this;
    }
    
    public MessageBuilder addBoldLine(String line) {
        message.append(String.format("<b>%s</b>", line));
        addBlankLine();
        return this;
    }
    
    public MessageBuilder addBlankLine() {
        message.append("</br>");
        return this;
    }
    
    public MessageBuilder startBlockquote() {
        message.append("<blockquote>");
        return this;
    }
    
    public MessageBuilder endBlockquote() {
        message.append("</blockquote>");
        return this;
    }
    
    public MessageBuilder addBlankLineInThisAmount(int amount) {
        for (int i = 0; i < amount; i++) {
            addBlankLine();
        }
        return this;
    }

    public String build() {
        return message.toString();
    }

}
