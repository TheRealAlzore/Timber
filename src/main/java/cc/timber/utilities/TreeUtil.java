package cc.timber.utilities;

import org.bukkit.block.Block;
import java.util.*;

public class TreeUtil {
    public static List<Block> getConnectedLogs(Block start) {
        Set<Block> visited = new HashSet<>();
        Queue<Block> queue = new LinkedList<>();
        queue.add(start);
        while (!queue.isEmpty()) {
            Block block = queue.poll();
            if (visited.contains(block)) continue;
            visited.add(block);
            for (int dx = -1; dx <= 1; dx++) {
                for (int dy = -1; dy <= 1; dy++) {
                    for (int dz = -1; dz <= 1; dz++) {
                        Block nearby = block.getRelative(dx, dy, dz);
                        if (!visited.contains(nearby) && nearby.getType().name().contains("LOG")) {
                            queue.add(nearby);
                        }
                    }
                }
            }
        }
        return new ArrayList<>(visited);
    }
}