package net.arikia.dev.drpc;

import com.sun.jna.Structure;
import java.util.Arrays;
import java.util.List;

public class DiscordRichPresence extends Structure {
   public String state;
   public String details;
   public long startTimestamp;
   public long endTimestamp;
   public String largeImageKey;
   public String largeImageText;
   public String smallImageKey;
   public String smallImageText;
   public String partyId;
   public int partySize;
   public int partyMax;
   /** @deprecated */
   @Deprecated
   public String matchSecret;
   public String spectateSecret;
   public String joinSecret;
   /** @deprecated */
   @Deprecated
   public int instance;

   public List getFieldOrder() {
      return Arrays.asList("state", "details", "startTimestamp", "endTimestamp", "largeImageKey", "largeImageText", "smallImageKey", "smallImageText", "partyId", "partySize", "partyMax", "matchSecret", "joinSecret", "spectateSecret", "instance");
   }

   public static class Builder {
      // $FF: renamed from: p net.arikia.dev.drpc.DiscordRichPresence
      private DiscordRichPresence field_2712 = new DiscordRichPresence();

      public Builder(String state) {
         this.field_2712.state = state;
      }

      public DiscordRichPresence.Builder setDetails(String details) {
         this.field_2712.details = details;
         return this;
      }

      public DiscordRichPresence.Builder setStartTimestamps(long start) {
         this.field_2712.startTimestamp = start;
         return this;
      }

      public DiscordRichPresence.Builder setEndTimestamp(long end) {
         this.field_2712.endTimestamp = end;
         return this;
      }

      public DiscordRichPresence.Builder setBigImage(String key, String text) {
         if (text != null && !text.equalsIgnoreCase("") && key == null) {
            throw new IllegalArgumentException("Image key must not be null when assigning a hover text.");
         } else {
            this.field_2712.largeImageKey = key;
            this.field_2712.largeImageText = text;
            return this;
         }
      }

      public DiscordRichPresence.Builder setSmallImage(String key, String text) {
         if (text != null && !text.equalsIgnoreCase("") && key == null) {
            throw new IllegalArgumentException("Image key must not be null when assigning a hover text.");
         } else {
            this.field_2712.smallImageKey = key;
            this.field_2712.smallImageText = text;
            return this;
         }
      }

      public DiscordRichPresence.Builder setParty(String party, int size, int max) {
         this.field_2712.partyId = party;
         this.field_2712.partySize = size;
         this.field_2712.partyMax = max;
         return this;
      }

      /** @deprecated */
      @Deprecated
      public DiscordRichPresence.Builder setSecrets(String match, String join, String spectate) {
         this.field_2712.matchSecret = match;
         this.field_2712.joinSecret = join;
         this.field_2712.spectateSecret = spectate;
         return this;
      }

      public DiscordRichPresence.Builder setSecrets(String join, String spectate) {
         this.field_2712.joinSecret = join;
         this.field_2712.spectateSecret = spectate;
         return this;
      }

      /** @deprecated */
      @Deprecated
      public DiscordRichPresence.Builder setInstance(boolean i) {
         this.field_2712.instance = i ? 1 : 0;
         return this;
      }

      public DiscordRichPresence build() {
         return this.field_2712;
      }
   }
}
