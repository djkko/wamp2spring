/**
 * Copyright 2017-2017 Ralph Schaer <ralphschaer@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package ch.rasc.wampspring.config;

import java.util.List;

import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.support.DefaultHandshakeHandler;

public class PreferBinaryHandshakeHandler extends DefaultHandshakeHandler {

	@Override
	protected String selectProtocol(List<String> requestedProtocols,
			WebSocketHandler webSocketHandler) {

		if (requestedProtocols.contains(WampSubProtocolHandler.MSGPACK_PROTOCOL)) {
			return WampSubProtocolHandler.MSGPACK_PROTOCOL;
		}

		if (requestedProtocols.contains(WampSubProtocolHandler.SMILE_PROTOCOL)) {
			return WampSubProtocolHandler.SMILE_PROTOCOL;
		}

		if (requestedProtocols.contains(WampSubProtocolHandler.CBOR_PROTOCOL)) {
			return WampSubProtocolHandler.CBOR_PROTOCOL;
		}

		return super.selectProtocol(requestedProtocols, webSocketHandler);
	}

}
