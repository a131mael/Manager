/*
 * JBoss, Home of Professional Open Source
 * Copyright 2013, Red Hat, Inc. and/or its affiliates, and individual
 * contributors by the @authors tag. See the copyright.txt in the
 * distribution for a full listing of individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.aaf.uiweb.service;

import java.util.ArrayList;
import java.util.List;

import org.aaf.dto.LineUpDTO;
import org.aaf.dto.MatchDTO;
import org.aaf.dto.TeamDTO;
import org.aaf.uiweb.util.EndPoints;
import org.aaf.uiweb.util.JSONPPost;
import org.aaf.uiweb.util.JsonReader;
import org.json.JSONObject;

import com.cedarsoftware.util.io.JsonWriter;

public class MatchService {

	
	public List<MatchDTO> getLastMatches(Long idTeam) {
		
		return  new ArrayList<MatchDTO>();
	}
	
	@SuppressWarnings("unchecked")
	public List<MatchDTO> getMatches(Long idTeam,int session) {
		
		JSONObject jo = JsonReader.getObject(EndPoints.GET_MATCHES+idTeam+"/"+session);
    	List<MatchDTO> matches = ((List<MatchDTO>) com.cedarsoftware.util.io.JsonReader.jsonToJava(jo.toString()));
		return matches;
	}

	public MatchDTO getLastMatch(Long id) {
		
		return  new MatchDTO();
	}

	public void saveLineUp(LineUpDTO lineUP) {
		JSONPPost.sendJson(JsonWriter.objectToJson(lineUP), EndPoints.SAVE_LINEUP);
		
	}

	public LineUpDTO getLineUp(Long matchId, Long idTeam) {
		JSONObject jo = JsonReader.getObject(EndPoints.GET_LINEUP+matchId+"/"+idTeam);
    	LineUpDTO lineUp = (LineUpDTO) com.cedarsoftware.util.io.JsonReader.jsonToJava(jo.toString());
		return lineUp;
	}

}
