package com.portfoliobackend.application.controller;

import com.portfoliobackend.application.dto.req.ProjectReqDto;
import com.portfoliobackend.application.dto.res.ProjectResDto;
import com.portfoliobackend.application.handlers.IProjectHandler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import static com.portfoliobackend.infrastructure.config.Constants.*;

@RestController
@RequestMapping("/project")
@RequiredArgsConstructor
@Tag(name = "project", description = "Endpoint related to project")
public class ProjectController {
    private final IProjectHandler projectHandler;

    @Operation(summary = "add new project", responses = {
            @ApiResponse(responseCode = "201", description = PROJECT_CREATED_MESSAGE,
                    content = @Content(mediaType = "application/json", schema = @Schema(ref = "#/components/schemas/Message"))),
            @ApiResponse(responseCode = "409", description = SWAGGER_PROJECT_ERROR,
                    content = @Content)
    })
    @PostMapping
    public ResponseEntity<Map<String, String>> createProject(@RequestBody ProjectReqDto projectReqDto) {
        projectHandler.createProject(projectReqDto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(Collections.singletonMap(RESPONSE_MESSAGE_KEY, PROJECT_CREATED_MESSAGE));
    }

    @Operation(summary = "Get projects for one user", responses = {
            @ApiResponse(responseCode = "200", description = "[{}]",
                    content = @Content(mediaType = "application/json", schema = @Schema(ref = "#/components/schemas/Message")))

    })
    @GetMapping
    public ResponseEntity<List<ProjectResDto>> getProjects(@RequestParam int userCode, @RequestParam int pageSize, @RequestParam int pageNumber) {
        return ResponseEntity.ok(projectHandler.getProjects(userCode, pageSize, pageNumber));
    }

    @Operation(summary = "Update project", responses = {
            @ApiResponse(responseCode = "200", description = PROJECT_UPDATE_MESSAGE,
                    content = @Content(mediaType = "application/json", schema = @Schema(ref = "#/components/schemas/Message"))),
            @ApiResponse(responseCode = "409", description = PROJECT_NOT_FOUND,
                    content = @Content(mediaType = "application/json", schema = @Schema(ref = "#/components/schemas/Error")))
    })
    @PutMapping("/{id}")
    public ResponseEntity<Map<String, String>> updateProjects(@PathVariable Long id, @RequestBody ProjectReqDto projectReqDto) {
        projectHandler.updateProject(projectReqDto, id);
        return ResponseEntity.status(HttpStatus.OK)
                .body(Collections.singletonMap(RESPONSE_MESSAGE_KEY, PROJECT_UPDATE_MESSAGE));
    }

    @Operation(summary = "Delete project", responses = {
        @ApiResponse(responseCode = "200", description = PROJECT_DELETE_MESSAGE,
                content = @Content(mediaType = "application/json", schema = @Schema(ref = "#/components/schemas/Message")))
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String,String>> deleteProjects(@PathVariable Long id){
        projectHandler.deleteProject(id);
        return ResponseEntity.status(HttpStatus.OK)
                .body(Collections.singletonMap(RESPONSE_MESSAGE_KEY,PROJECT_DELETE_MESSAGE));
    }
}
