package net.arikia.dev.drpc;

import com.sun.jna.Structure;
import java.util.Arrays;
import java.util.List;
import net.arikia.dev.drpc.callbacks.DisconnectedCallback;
import net.arikia.dev.drpc.callbacks.ErroredCallback;
import net.arikia.dev.drpc.callbacks.JoinGameCallback;
import net.arikia.dev.drpc.callbacks.JoinRequestCallback;
import net.arikia.dev.drpc.callbacks.ReadyCallback;
import net.arikia.dev.drpc.callbacks.SpectateGameCallback;

public class DiscordEventHandlers extends Structure {
   public ReadyCallback ready;
   public DisconnectedCallback disconnected;
   public ErroredCallback errored;
   public JoinGameCallback joinGame;
   public SpectateGameCallback spectateGame;
   public JoinRequestCallback joinRequest;

   public List getFieldOrder() {
      return Arrays.asList("ready", "disconnected", "errored", "joinGame", "spectateGame", "joinRequest");
   }

   public static class Builder {
      // $FF: renamed from: h net.arikia.dev.drpc.DiscordEventHandlers
      DiscordEventHandlers field_2227 = new DiscordEventHandlers();

      public DiscordEventHandlers.Builder setReadyEventHandler(ReadyCallback r) {
         this.field_2227.ready = r;
         return this;
      }

      public DiscordEventHandlers.Builder setDisconnectedEventHandler(DisconnectedCallback d) {
         this.field_2227.disconnected = d;
         return this;
      }

      public DiscordEventHandlers.Builder setErroredEventHandler(ErroredCallback e) {
         this.field_2227.errored = e;
         return this;
      }

      public DiscordEventHandlers.Builder setJoinGameEventHandler(JoinGameCallback j) {
         this.field_2227.joinGame = j;
         return this;
      }

      public DiscordEventHandlers.Builder setSpectateGameEventHandler(SpectateGameCallback s) {
         this.field_2227.spectateGame = s;
         return this;
      }

      public DiscordEventHandlers.Builder setJoinRequestEventHandler(JoinRequestCallback j) {
         this.field_2227.joinRequest = j;
         return this;
      }

      public DiscordEventHandlers build() {
         return this.field_2227;
      }
   }
}
