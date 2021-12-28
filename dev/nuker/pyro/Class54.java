/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  io.netty.buffer.ByteBufAllocator
 *  io.netty.channel.Channel
 *  io.netty.channel.Channel$Unsafe
 *  io.netty.channel.ChannelConfig
 *  io.netty.channel.ChannelFuture
 *  io.netty.channel.ChannelId
 *  io.netty.channel.ChannelMetadata
 *  io.netty.channel.ChannelOutboundInvoker
 *  io.netty.channel.ChannelPipeline
 *  io.netty.channel.ChannelProgressivePromise
 *  io.netty.channel.ChannelPromise
 *  io.netty.channel.EventLoop
 *  io.netty.util.Attribute
 *  io.netty.util.AttributeKey
 */
package dev.nuker.pyro;

import dev.nuker.pyro.Class51;
import dev.nuker.pyro.Class53;
import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.Channel;
import io.netty.channel.ChannelConfig;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelId;
import io.netty.channel.ChannelMetadata;
import io.netty.channel.ChannelOutboundInvoker;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.ChannelProgressivePromise;
import io.netty.channel.ChannelPromise;
import io.netty.channel.EventLoop;
import io.netty.util.Attribute;
import io.netty.util.AttributeKey;
import java.net.SocketAddress;

public class Class54
implements Channel {
    public Class51 Field4437;

    public boolean Method6340() {
        return false;
    }

    public ChannelFuture Method6341(Throwable throwable) {
        return null;
    }

    public Channel Method6342() {
        return null;
    }

    public ChannelFuture Method6343(SocketAddress socketAddress, SocketAddress socketAddress2) {
        return null;
    }

    public ChannelFuture Method6344() {
        return null;
    }

    public boolean Method6345() {
        return false;
    }

    public EventLoop Method6346() {
        return null;
    }

    public ChannelFuture Method6347(Object object) {
        return null;
    }

    public ChannelMetadata Method6348() {
        return null;
    }

    public ChannelFuture Method6349() {
        return null;
    }

    public Attribute Method6350(AttributeKey attributeKey) {
        return new Class53(this);
    }

    public ChannelFuture Method6351(Object object, ChannelPromise channelPromise) {
        return null;
    }

    public ByteBufAllocator Method6352() {
        return null;
    }

    public ChannelPromise Method6353() {
        return null;
    }

    public boolean Method6354() {
        return false;
    }

    public ChannelFuture Method6355(Object object, ChannelPromise channelPromise) {
        return null;
    }

    public Class54(Class51 class51) {
        this.Field4437 = class51;
    }

    public ChannelConfig Method6356() {
        return null;
    }

    public ChannelFuture Method6357(SocketAddress socketAddress, ChannelPromise channelPromise) {
        return null;
    }

    public long Method6358() {
        return 0L;
    }

    public long Method6359() {
        return 0L;
    }

    public int Method6360(Channel channel) {
        return 0;
    }

    public ChannelPromise Method6361() {
        return null;
    }

    public boolean Method6362(AttributeKey attributeKey) {
        return false;
    }

    public ChannelFuture Method6363(ChannelPromise channelPromise) {
        return null;
    }

    public Channel Method6364() {
        return null;
    }

    public ChannelFuture Method6365(Object object) {
        return null;
    }

    public ChannelFuture Method6366(ChannelPromise channelPromise) {
        return null;
    }

    public ChannelFuture Method6367(SocketAddress socketAddress) {
        return null;
    }

    public ChannelFuture Method6368(SocketAddress socketAddress) {
        return null;
    }

    public ChannelId Method6369() {
        return null;
    }

    public SocketAddress Method6370() {
        return null;
    }

    public ChannelPipeline Method6371() {
        return null;
    }

    public ChannelFuture Method6372() {
        return null;
    }

    public Channel Method6373() {
        return null;
    }

    public ChannelFuture Method6374(SocketAddress socketAddress, ChannelPromise channelPromise) {
        return null;
    }

    public Channel.Unsafe Method6375() {
        return null;
    }

    public ChannelFuture Method6376(ChannelPromise channelPromise) {
        return null;
    }

    public ChannelOutboundInvoker Method6377() {
        return this.Method6373();
    }

    public ChannelFuture Method6378() {
        return null;
    }

    public ChannelProgressivePromise Method6379() {
        return null;
    }

    public SocketAddress Method6380() {
        return null;
    }

    public ChannelOutboundInvoker Method6381() {
        return this.Method6364();
    }

    public ChannelFuture Method6382() {
        return null;
    }

    public ChannelFuture Method6383(SocketAddress socketAddress, SocketAddress socketAddress2, ChannelPromise channelPromise) {
        return null;
    }

    public boolean Method6384() {
        return false;
    }

    public int Method6385(Object object) {
        return this.Method6360((Channel)object);
    }
}

