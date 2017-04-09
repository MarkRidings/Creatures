package FileIO

import java.io._
import java.nio.file.{Files, Paths}

import Settings.GameSettings

object FileCreator {

  val newline = sys.props("line.separator")

  def createSavedGameFile(saveName: String): Unit = {

    val dir = Paths.get(System.getProperty("user.dir"))
    if (!Files.exists(Paths.get(s"$dir/saves"))) {
      Files.createDirectories(Paths.get(s"$dir/saves"))
    }

    val path = Paths.get(s"$dir/saves/$saveName.sv")
    val writer = new BufferedWriter(new FileWriter(path.toFile))
    writer.write(GameSettings.orgName + newline)
    writer.write(GameSettings.week + newline)
    writer.write(GameSettings.year + newline)
    writer.write(GameSettings.currentMoney + newline)
    writer.close()
  }
}
