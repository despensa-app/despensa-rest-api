package dev.nmarulo.despensa_app.app.authentication;

import dev.nmarulo.despensa_app.app.authentication.dtos.AuthenticationReq;
import dev.nmarulo.despensa_app.app.authentication.dtos.AuthenticationRes;
import dev.nmarulo.despensa_app.app.authentication.dtos.RegisterAuthenticationReq;
import dev.nmarulo.despensa_app.app.authentication.dtos.RegisterAuthenticationRes;
import dev.nmarulo.despensa_app.commons.dtos.ErrorRes;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

@Tag(name = "Authentication")
public interface AuthenticationApi {
    
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200",
                     content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                                        schema = @Schema(implementation = AuthenticationRes.class))),
        @ApiResponse(responseCode = "401",
                     content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                                        schema = @Schema(implementation = ErrorRes.class),
                                        examples = @ExampleObject(value = """
                                            {
                                                "error": {
                                                    "type": "about:blank",
                                                    "title": "Bad Request",
                                                    "status": 400,
                                                    "detail": "The user/password is incorrect."
                                                }
                                            }
                                            """)))
    })
    ResponseEntity<AuthenticationRes> login(AuthenticationReq request);
    
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200",
                     content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                                        schema = @Schema(implementation = RegisterAuthenticationRes.class))),
        @ApiResponse(responseCode = "400",
                     content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                                        schema = @Schema(implementation = ErrorRes.class),
                                        examples = @ExampleObject(value = """
                                            {
                                                "error": {
                                                    "type": "about:blank",
                                                    "title": "Bad Request",
                                                    "status": 400,
                                                    "detail": "Error when registering ther user."
                                                }
                                            }
                                            """)))
    })
    ResponseEntity<RegisterAuthenticationRes> register(@RequestBody RegisterAuthenticationReq request);
    
}
