package com.concepts.spring.services.actions.implementations;

import com.concepts.spring.model.entity.Node;
import com.concepts.spring.services.actions.AbstractAction;
import com.concepts.spring.services.documentAssembler.context.DocAssRunnerContext;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;


@Slf4j
public class WriteTxtFileAction extends AbstractAction {

    public WriteTxtFileAction(DocAssRunnerContext context) {
        super(context);
    }

    @Override
    public void execute(Node node) {

        String fileName = "output." + new SimpleDateFormat("yyyy-MM-dd.HH-mm'.txt'").format(new Date());

        String output = getContext().getOutput();

        try{
            createFile(fileName);
            writeFile (fileName, output);
        } catch (FileNotFoundException e) {
            log.error("Arquivo não encontrado");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void createFile(String fileName) throws IOException {
        File file = new File("outputs\\" + fileName);
        file.getParentFile().mkdir();
        file.createNewFile();
    }

    public void writeFile(String fileName, String output) throws FileNotFoundException {

        PrintWriter writer = new PrintWriter("outputs\\" + fileName);

        writer.println(output);
        writer.close();
    }
}
