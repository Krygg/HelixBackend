/*
 * Copyright (C) 2003-2014, C. Ramakrishnan / Illposed Software.
 * All rights reserved.
 *
 * This code is licensed under the BSD 3-Clause license.
 * See file LICENSE (or LICENSE.html) for more information.
 */

package com.illposed.osc.transport.udp;

import java.io.IOException;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.net.StandardProtocolFamily;
import java.net.UnknownHostException;
import java.nio.channels.DatagramChannel;

/**
 * An abstract superclass.
 * To send OSC messages, use {@link OSCPortOut}.
 * To listen for OSC messages, use {@link OSCPortIn}.
 */
public class OSCPort {

	private final SocketAddress local;
	private final SocketAddress remote;
	private final DatagramChannel channel;

	public static final int DEFAULT_SC_OSC_PORT = 57110;
	public static final int DEFAULT_SC_LANG_OSC_PORT = 57120;

	public OSCPort(final SocketAddress local, final SocketAddress remote) throws IOException {

		this.local = local;
		this.remote = remote;
		final DatagramChannel tmpChannel;
		if (InetSocketAddress.class.isInstance(local)) {
			final InetSocketAddress localIsa = (InetSocketAddress) local;
			final InetSocketAddress remoteIsa = (InetSocketAddress) remote;
			if (!localIsa.getAddress().getClass().equals(
					remoteIsa.getAddress().getClass()))
			{
				throw new IllegalArgumentException(
						"local and remote addresses are not of the same family"
						+ " (IP v4 vs v6)");
			}
			if (Inet4Address.class.isInstance(localIsa.getAddress())) {
				tmpChannel = DatagramChannel.open(StandardProtocolFamily.INET);
			} else if (Inet6Address.class.isInstance(localIsa.getAddress())) {
				tmpChannel = DatagramChannel.open(StandardProtocolFamily.INET6);
			} else {
				throw new IllegalArgumentException(
						"Unknown address type: "
						+ localIsa.getAddress().getClass().getCanonicalName());
			}
		} else {
			tmpChannel = DatagramChannel.open();
		}
		this.channel = tmpChannel;

		this.channel.setOption(java.net.StandardSocketOptions.SO_REUSEADDR, true);
		this.channel.socket().bind(local);
	}

	/**
	 * The port that the SuperCollider <b>synth</b> engine
	 * usually listens to.
	 * @return default SuperCollider <b>synth</b> UDP port
	 * @see #DEFAULT_SC_OSC_PORT
	 */
	public static int defaultSCOSCPort() {
		return DEFAULT_SC_OSC_PORT;
	}

	/**
	 * The port that the SuperCollider <b>language</b> engine
	 * usually listens to.
	 * @return default SuperCollider <b>language</b> UDP port
	 * @see #DEFAULT_SC_LANG_OSC_PORT
	 */
	public static int defaultSCLangOSCPort() {
		return DEFAULT_SC_LANG_OSC_PORT;
	}

	/**
	 * Generates an wildcard IP address (matches all (local) IPs) of the same
	 * family as the given address.
	 * @param address from this we figure out the IP address family (IP v4 or v6)
	 * @return
	 *   <code>0.0.0.0</code> if IP v4,
	 *   <code>::</code> if IP v6,
	 *   <i>undefined behavior</i> otherwise
	 * @throws UnknownHostException this should never occur
	 */
	public static InetAddress generateWildcard(final SocketAddress address) throws UnknownHostException {
		return InetAddress.getByName((extractFamily(address) == 4) ? "0.0.0.0" : "::");
	}

	/**
	 * Extracts the (IP) family of a given address.
	 * @param address the address of which to return the (IP) family of
	 * @return
	 *   <code>4</code> if IP v4,
	 *   <code>6</code> if IP v6,
	 *   <code>0</code> otherwise
	 */
	public static int extractFamily(final SocketAddress address) {

		final int family;
		if (InetSocketAddress.class.isInstance(address)) {
			final InetSocketAddress inetAddress = (InetSocketAddress) address;
			if (Inet4Address.class.isInstance(inetAddress.getAddress())) {
				family = 4;
			} else if (Inet6Address.class.isInstance(inetAddress.getAddress())) {
				family = 6;
			} else {
				family = 0;
			}
		} else {
			family = 0;
		}

		return family;
	}


	/**
	 * Returns the channel associated with this port.
	 * @return this ports channel
	 */
	protected DatagramChannel getChannel() {
		return channel;
	}

	public void connect() throws IOException {

		if (getRemoteAddress() == null) {
			throw new IllegalStateException(
					"Can not connect a socket without a remote address specified");
		}
		getChannel().connect(getRemoteAddress());
	}

	public void disconnect() throws IOException {
		getChannel().disconnect();
	}

	public boolean isConnected() {
		return getChannel().isConnected();
	}

	public SocketAddress getLocalAddress() {
		return local;
	}

	public SocketAddress getRemoteAddress() {
		return remote;
	}

	/**
	 * Close the socket and free-up resources.
	 * It is recommended that clients call this when they are done with the
	 * port.
	 * @throws IOException If an I/O error occurs on the channel
	 */
	public void close() throws IOException {
		channel.close();
	}
}
