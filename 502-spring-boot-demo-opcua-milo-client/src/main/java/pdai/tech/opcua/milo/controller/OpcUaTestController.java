package pdai.tech.opcua.milo.controller;

import java.util.List;

import com.google.common.collect.ImmutableList;
import lombok.SneakyThrows;
import org.eclipse.milo.opcua.stack.core.Identifiers;
import org.eclipse.milo.opcua.stack.core.types.builtin.ByteString;
import org.eclipse.milo.opcua.stack.core.types.builtin.DataValue;
import org.eclipse.milo.opcua.stack.core.types.builtin.NodeId;
import org.eclipse.milo.opcua.stack.core.types.builtin.QualifiedName;
import org.eclipse.milo.opcua.stack.core.types.structured.HistoryReadValueId;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pdai.tech.opcua.milo.entity.CustomStructType;
import pdai.tech.opcua.milo.properties.OpcUaProperties;
import pdai.tech.opcua.milo.service.impl.IOpcUaService;

/**
 * @author pdai
 */
@RestController
@RequestMapping("/opcua")
public class OpcUaTestController {

    /**
     * opc ua service.
     */
    private final IOpcUaService opcUaService;

    /**
     * opc-ua properties.
     */
    private final OpcUaProperties opcUaProperties;

    /**
     * init.
     *
     * @param opcUaService2    opc service
     * @param opcUaProperties2 opc config
     */
    public OpcUaTestController(final IOpcUaService opcUaService2, OpcUaProperties opcUaProperties2) {
        this.opcUaService = opcUaService2;
        this.opcUaProperties = opcUaProperties2;
    }

    /**
     * fetch data test api.
     *
     * @return opc ua data
     */
    @SneakyThrows
    @GetMapping("data")
    public ResponseEntity<DataValue> fetchData() {
        return ResponseEntity.ok(opcUaService.retrieveGenericData(getNodeId(), 0));
    }

    /**
     * fetch data list test api.
     *
     * @return opc ua data
     */
    @SneakyThrows
    @GetMapping("dataList")
    public ResponseEntity<List<DataValue>> fetchDataList() {
        List<NodeId> nodeIds = ImmutableList.of(
                Identifiers.Server_ServerStatus_State,
                Identifiers.Server_ServerStatus_CurrentTime);
        return ResponseEntity.ok(opcUaService.retrieveGenericDataList(nodeIds, 0));
    }

    /**
     * fetch custom data test api.
     *
     * @return opc ua data
     */
    @SneakyThrows
    @GetMapping("custom")
    public ResponseEntity<CustomStructType> fetchCustomData() {
        return ResponseEntity.ok(opcUaService.retrieveCustomData(getNodeId()));
    }

    /**
     * fetch custom History data test api.
     *
     * @return opc ua data
     */
    @SneakyThrows
    @GetMapping("customHistory")
    public ResponseEntity<List<CustomStructType>> fetchCustomHistoryData() {
        return ResponseEntity.ok(opcUaService.retrieveCustomHistoryData(
                new HistoryReadValueId(getNodeId(), null, new QualifiedName(getNodeId().getNamespaceIndex(),
                        "CustomStructType"), ByteString.NULL_VALUE)));
    }

    @NotNull
    private NodeId getNodeId() {
        return new NodeId(opcUaProperties.getMyNode().getNamespaceIndex(), opcUaProperties.getMyNode().getIdentifier());
    }
}
