package test.java;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Iterator;

public class NonBlockingChannelEchoServer {

	private static final int ECHO_PORT = 10007;
	private static final int BUF_SIZE = 1000;

	// ���o�͂Ɋւ��鑀����Ď����邽�߂̃N���X
	private Selector selector;

	public static void main(String[] args) {
		new NonBlockingChannelEchoServer().run();
	}

	public void run() {
		// �Ď�����Ώۂł���`���l����SelectableChannel�N���X
		// ServerSocketChannel��SelectableChannel���p�������N���X
		ServerSocketChannel serverChannel = null;
		try {
			selector = Selector.open();
			serverChannel = ServerSocketChannel.open();
			serverChannel.configureBlocking(false);
			serverChannel.socket().bind(new InetSocketAddress(ECHO_PORT));
			serverChannel.register(selector, SelectionKey.OP_ACCEPT);
			System.out.println("NonBlockingChannelEchoServer���N�����܂���(port=" 
					+ serverChannel.socket().getLocalPort() + ")");
			while (selector.select() > 0) {
				for (Iterator it = selector.selectedKeys().iterator(); it.hasNext();) {
					SelectionKey key = (SelectionKey) it.next();
					it.remove();
					if (key.isAcceptable()) {
						doAccept((ServerSocketChannel) key.channel());
					} else if (key.isReadable()) {
						doRead((SocketChannel) key.channel());
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (serverChannel != null && serverChannel.isOpen()) {
				try {
					System.out.println("NonBlockingChannelEchoServer���~���܂��B");
					serverChannel.close();
				} catch (IOException e) {
				}
			}
		}
	}

	private void doAccept(ServerSocketChannel serverChannel) {
		try {
			SocketChannel channel = serverChannel.accept();
			String remoteAddress = channel.socket().getRemoteSocketAddress().toString();
			System.out.println(remoteAddress + ":[�ڑ�����܂���]");
			channel.configureBlocking(false);
			channel.register(selector, SelectionKey.OP_READ);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void doRead(SocketChannel channel) {
		ByteBuffer buf = ByteBuffer.allocate(BUF_SIZE);
		Charset charset = Charset.forName("UTF-8");
		String remoteAddress = channel.socket().getRemoteSocketAddress().toString();
		try {
			if (channel.read(buf) < 0) {
				return;
			}
			buf.flip();
			System.out.print(remoteAddress + ":" + charset.decode(buf).toString());
			buf.flip();
			channel.write(buf);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			System.out.println(remoteAddress + ":[�ؒf���܂���]");
			try {
				channel.close();
			} catch (IOException e) {
			}
		}
	}

}