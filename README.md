# Spigot_ChatBubbles (ClansPlus Enhanced Fork)

A Bukkit/Spigot/Paper Minecraft plugin that displays holographic chat bubbles above players' and NPCs' heads when they chat.

---

## 🌟 What's New in This Fork

### 🛡️ ClansPlus Integration & Secret Chat Protection
- **Automatic Clan Chat Detection**: When a player is in clan chat mode (via `/clan chat` or `/c chat` from **ClansPlus**), messages sent to clan members **will NOT** generate a chat bubble over their head.
- **Safe Gossiping**: Prevents nearby non-clan players from eavesdropping or seeing private clan communications in holographic bubbles.
- **Interactive Prompt Protection**: Prevents chat bubbles from appearing during clan creation or name-setting prompts in chat.
- **Seamless Public Chat**: When clan chat mode is disabled, chat bubbles display normally for public messages.
- **Configurable**: Fully toggleable via `ChatBubble_Ignore_ClansPlus_ClanChat: true` in `config.yml`.
- **Event Cancellation Fix**: Event listeners now include `ignoreCancelled = true` to respect cancelled chat events from other chat management plugins.

---

## 📋 Requirements & Dependencies

- **Server Software**: Spigot, Paper, Purpur, Folia (1.16.5 - 1.21+)
- **Java**: 17 or higher
- **Hologram Provider** (at least one required):
  - [DecentHolograms](https://github.com/DecentSoftware-eu/DecentHolograms) *(Recommended)*
  - [HolographicDisplays](https://github.com/filoghost/HolographicDisplays)
- **Optional Integrations**:
  - [ClansPlus](https://github.com/CortezRomeo/ClansPlus) - Clan chat isolation support
  - [PlaceholderAPI](https://www.spigotmc.org/resources/placeholderapi.6245/) - Custom placeholders in bubbles
  - [Citizens](https://www.spigotmc.org/resources/citizens.13811/) - NPC chat bubbles via trait (`/trait chatbubble`)
  - [Factions](https://www.massivecraft.com/factions) - Faction chat visibility

---

## ⚙️ Configuration (`config.yml`)

```yaml
# 0 - Every chat message becomes a ChatBubble
# 1 - Command messages starting with "/cb <message>" become a ChatBubble
# 2 - Every chat message is visible as a ChatBubble to players in the same ChatBubble permission group
# 3 - Every chat message is visible as a ChatBubble to players in the same Faction
# 4 - Every chat message appears only in text chat like vanilla but still allows a noise to be played
# 5 - Messages starting with ".<message>" become a ChatBubble.
# 6 - Every message becomes a ChatBubble except for messages starting with "!<message>"
ChatBubble_Configuration_Mode: 0

# Time the bubble lasts (in ticks, 20 ticks = 1 sec)
ChatBubble_Life: 120

# Height offset above player's head
ChatBubble_Height_Offset: 2.5

# Max viewing distance in blocks
ChatBubble_Viewing_Distance: 15

# Whether players can see their own chat bubbles
ChatBubble_See_Own_Bubbles: true

# ClansPlus Clan Chat support:
# When true, typing in /clan chat will not create a bubble over the player's head
ChatBubble_Ignore_ClansPlus_ClanChat: true

# Sound played when a chat bubble appears
ChatBubble_Play_Sound: true
ChatBubble_Sound_Name: "block.note_block.bell"
ChatBubble_Sound_Volume: 1.0

# Event Priority (NORMAL, HIGH, HIGHEST, LOW, LOWEST, MONITOR)
ChatBubble_EventPriority: "NORMAL"
```

---

## 📜 Commands & Permissions

| Command | Alias | Description | Permission |
|---|---|---|---|
| `/chatbubble <message>` | `/cb` | Spawns a manual chat bubble (Mode 1) | `chatbubble.use` |
| `/chatbubbletoggle` | `/cbtoggle`, `/cbt` | Toggle seeing/sending chat bubbles for yourself | `chatbubble.toggle` |
| `/chatbubblereload` | `/cbreload` | Reloads configuration files | `chatbubbles.reload` |

---

## 🔨 Building from Source

This project uses **Apache Maven**:

```bash
# Clone the repository
git clone https://github.com/DarkIgnite/Spigot_ChatBubbles.git

# Navigate to project directory
cd Spigot_ChatBubbles

# Build JAR package
mvn clean package
```

The compiled plugin JAR will be located in the `target/` directory:
`target/ChatBubbles-1.21.0.b.1-FORK.jar`

---

## 📄 Credits & License

- Original plugin created by **TheTealViper** ([SpigotMC Resource](https://www.spigotmc.org/resources/chatbubbles.49387/)).
- ClansPlus hook and compatibility improvements by **DarkIgnite**.
