package ch.desm.middleware.core.communication.replay;

import ch.desm.middleware.core.communication.message.MessageCommon;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * Can parse log files of following format:
 * 2016-04-28 18:21:18 OML_Kontakte_$8_FSS_0EGF;OS;;;;;on;petrinet_obermatt;#
 */
public class ReplayLoader {

    private static Logger LOGGER = Logger.getLogger(ReplayLoader.class);

    private final DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss", Locale.ENGLISH);

    public Replay loadFromLogFile(String fname) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(fname))) {
            final List<String> lines = new ArrayList<>();
            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }

            return loadFromLogLines(lines);
        }
    }

    public Replay loadFromLogLines(List<String> logLines) {
        final List<ReplayEvent> events = new ArrayList<>();
        Long firstTs = null;

        for (String line : logLines) {
            try {
                final LogEntry entry = parseLine(firstTs, line);
                if (entry != null) {
                    events.add(new ReplayEvent(entry.getOffset(), entry.getMessage()));
                    if (firstTs == null) {
                        firstTs = entry.getTime();
                    }
                }
            } catch (ParseException e) {
                LOGGER.log(Level.WARN, "Unable to parse line " + line + ": " + e);
            }
        }

        return new Replay(events);
    }

    private LogEntry parseLine(Long firstTs, String line) throws ParseException {
        if (line.trim().isEmpty()) {
            return null;
        }

        final String lineParts[] = line.split(" ");
        if (lineParts.length != 3) {
            throw new ParseException("Invalid replay line format. Must be three parts separated by space.", 0);
        }

        final Date date = dateFormat.parse(lineParts[0] + " " + lineParts[1]);
        final long time = date.getTime();
        final long offset = (firstTs != null) ? (time - firstTs) : 0;

        final String[] messageParts = parseMessage(lineParts[2]);
        final String message = String.join(MessageCommon.MESSAGE_ELEMENT_DELIMITER, messageParts);
        final String topic = messageParts[MessageCommon.TOPIC];

        return new LogEntry(time, offset, topic, message);
    }

    private String[] parseMessage(String message) throws ParseException {
        String parts[] = message.split(MessageCommon.MESSAGE_ELEMENT_DELIMITER);

        // remove pending message delimiter
        if (parts.length > 0 && parts[parts.length - 1 ].equals(MessageCommon.MESSAGE_MESSAGE_DELIMITER)) {
            parts = Arrays.copyOfRange(parts, 0, parts.length - 1);
        }

        switch (parts.length) {
            case 9: // new message format
                return parts;
            case 8: // old message format
                return new String[]{
                    parts[0], parts[1], parts[2], parts[3], parts[4], parts[7], "b", parts[6]
                };
            default:
                throw new ParseException("Found message with invalid number of parts", 0);
        }
    }

    private class LogEntry {
        private final Long time;
        private final Long offset;
        private final String topc;
        private final String message;

        public LogEntry(Long time, Long offset, String topc, String message) {
            this.time = time;
            this.offset = offset;
            this.topc = topc;
            this.message = message;
        }

        public Long getTime() {
            return time;
        }

        public Long getOffset() {
            return offset;
        }

        public String getMessage() {
            return message;
        }

        public String getTopc() {
            return topc;
        }
    }

}
