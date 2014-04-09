package yermilov.ansimov.eliasomega

import org.apache.commons.io.FileUtils

def fileFrom = "sample.txt"
def fileTo = "sample.txt.eliasomega"

def fileContent = FileUtils.readFileToString(new File(fileFrom))

def eliasOmega = new EliasOmega()
def encoded = eliasOmega.encode fileContent

FileUtils.writeStringToFile(new File(fileTo), encoded)




