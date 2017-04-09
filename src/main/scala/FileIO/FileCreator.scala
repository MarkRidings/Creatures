package FileIO

import java.io._
import java.nio.file.{Files, Paths}

import Settings.GameSettings

object FileCreator {

  def createSavedGameFile(saveName: String): Unit = {

    val dir = Paths.get(System.getProperty("user.dir"))
    if (!Files.exists(Paths.get(s"$dir/saves"))) {
      println(Paths.get(s"$dir/saves"))
      Files.createDirectories(Paths.get(s"$dir/saves"))
    }

    val path = Paths.get(s"$dir/saves/$saveName.sv")
    val writer = new BufferedWriter(new FileWriter(path.toFile))
    writer.write(GameSettings.week + "\n")
    writer.write(GameSettings.year + "\n")
    writer.close()

  }
}
