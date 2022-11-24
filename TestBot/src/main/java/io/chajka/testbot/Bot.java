package io.chajka.testbot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.CopyMessage;
import org.telegram.telegrambots.meta.api.methods.commands.SetMyCommands;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.commands.BotCommand;
import org.telegram.telegrambots.meta.api.objects.commands.scope.BotCommandScopeDefault;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import javax.swing.text.TabableView;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

@SpringBootApplication
public class Bot extends TelegramLongPollingBot {

    static final String YES_BUTTON = "YES_BUTTON";
    static final String NO_BUTTON = "NO_BUTTON";
    static final String START_BUTTON = "START_BUTTON";

    static final String HUNT_BUTTON = "HUNT_BUTTON";
    static final String RAI_BUTTON = "RAI_BUTTON";

    public static boolean[][] MatchLogic = new boolean[200][200];
    ArrayList<Integer> randomNumbers = new ArrayList<Integer>();
   // ArrayList<String> userList = new ArrayList<String>();
    ArrayList<Integer> inSearchOf = new ArrayList<Integer>();
    ArrayList<Integer> tableOfWinners = new ArrayList<Integer>();
    ArrayList<Long> idList = new ArrayList<Long>();

    ArrayList<Integer> persentConcveer = new ArrayList<Integer>();

    ArrayList<Long> timeLast = new ArrayList<Long>();
//bool array

    private static UserRepository userRepository;
    private static User user;

    public Bot(UserRepository userRepository) {
        Bot.userRepository = userRepository;
    }


    public static void main(String[] args) throws TelegramApiException {
        SpringApplication.run(Bot.class, args);
        TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
        Bot bot = new Bot(userRepository);                  //We moved this line out of the register method, to access it later
        botsApi.registerBot(bot);
        bot.sendMessage(703699939L, "Hi sweetie, here we GO!");  //The L just turns the Integer into a Long





        User user = new User();
      //  if(userRepository.findById(703699939L).isPresent()){user = userRepository.findById(703699939L).get();}
        //user.setPhonetype("а теперь так");
     //   System.out.println(user.getPantstype());
       // userRepository.save(user);



      //  List<BotCommand> ListOfCommands = new ArrayList<>();
     //   ListOfCommands.add(new BotCommand("/start", "Правила игры"));
     //   ListOfCommands.add(new BotCommand("/help", "Не знаешь что делать?"));
        //   bot.execute(new SetMyCommands(ListOfCommands, new BotCommandScopeDefault(), null));

    }


    @Override
    public String getBotUsername() {
        return "ne_tinder_cottage_bot";
    }

    @Override
    public String getBotToken() {
        return "5840168704:AAHnfJpQajLBJdkLf0_7Ol_nUxyXQ7i11Fw";
    }

    @Override
    public void onUpdateReceived(Update update) {
        long idd = 0;
        if (update.hasMessage() && update.getMessage().hasText())
        {idd = update.getMessage().getFrom().getId();} else {idd = update.getCallbackQuery().getFrom().getId();}
        //  System.out.println(idd + "<<<<<<<<<<");


        //copyMessage(id, ui);

        if (update.hasMessage() && update.getMessage().hasText()) {
            var user = update.getMessage().getFrom();
            long id = user.getId();

            // System.out.println(id + "<<<<<<");
            var msg = update.getMessage();

            var ui = update.getMessage().getMessageId();
            var txt = update.getMessage().getText();
            //System.out.println(Integer.parseInt(update.getMessage().getText()) + "    ---<");
             if ("/start".equals(txt)) {
                registerUser(update.getMessage());

                startCommandReceived(id, update.getMessage().getChat().getFirstName());
            } else {
                //var prog = getProgress(id);
                if (userRepository.findById(idd).isPresent()){
                    User usert = userRepository.findById(idd).get();
                if (usert.getPantstype() == null) {
                    usert.setPantstype(txt);
                    userRepository.save(usert);
                    regSteps(id, ui, 2);
                } else if (usert.getTopestype() == null) {
                    usert.setTopestype(txt);
                    userRepository.save(usert);
                    regSteps(id, ui, 3);
                } else if (usert.getPhonetype() == null) {
                    usert.setPhonetype(txt);
                    userRepository.save(usert);
                    regSteps(id, ui, 4);
                } else if (usert.getShoestype() == null) {
                    usert.setShoestype(txt);
                    userRepository.save(usert);
                    regSteps(id, ui, 5);
                } else if (usert.getTattostype() == null) {
                    usert.setTattostype(txt);
                    userRepository.save(usert);
                    regSteps(id, ui, 6);
                } else if (usert.getPantscoolor() == null) {
                    usert.setPantscoolor(txt);
                    userRepository.save(usert);
                    regSteps(id, ui, 7);
                } else if (usert.getTopescolor() == null) {
                    usert.setTopescolor(txt);
                    userRepository.save(usert);
                    regSteps(id, ui, 8);
                } else if (usert.getSoxcolor() == null) {
                    usert.setSoxcolor(txt);
                    userRepository.save(usert);
                    regSteps(id, ui, 9);
                } else if (usert.getShoescolor() == null) {
                    usert.setShoescolor(txt);
                    userRepository.save(usert);
                    regSteps(id, ui, 10);
                } else if (usert.getUndwcolor() == null) {
                    usert.setUndwcolor(txt);
                    userRepository.save(usert);
                    regSteps(id, ui, 11);
                } else if (usert.getHeight() == null) {
                    usert.setHeight(Short.valueOf(txt));
                    userRepository.save(usert);
                    regSteps(id, ui, 12);
                } else if (usert.getWeight() == null) {
                    usert.setWeight(Short.valueOf(txt));
                    userRepository.save(usert);
                    regSteps(id, ui, 13);
                } else if (usert.getShoessize() == null) {
                    usert.setShoessize(Short.valueOf(txt));
                    userRepository.save(usert);
                    regSteps(id, ui, 14);
                } else if (usert.getHaircolor() == null) {
                    usert.setHaircolor(txt);
                    userRepository.save(usert);
                    regSteps(id, ui, 15);
                } else if (usert.getBodytype() == null) {
                    usert.setBodytype(txt);
                    userRepository.save(usert);
                    regSteps(id, ui, 16);
                } else if (usert.getEyecolor() == null) {
                    usert.setEyecolor(txt);
                    userRepository.save(usert);
                    regSteps(id, ui, 17);
                } else if (usert.getHobby() == null) {
                    usert.setHobby(txt);
                    userRepository.save(usert);
                    regSteps(id, ui, 18);
                } else if (usert.getStudy() == null) {
                    usert.setStudy(txt);
                    userRepository.save(usert);
                    regSteps(id, ui, 19);
                } else if (usert.getFood() == null) {
                    usert.setFood(txt);
                    userRepository.save(usert);
                    regSteps(id, ui, 20);
                } else if (usert.getFilm() == null) {
                    usert.setFilm(txt);
                    userRepository.save(usert);
                    regSteps(id, ui, 21);
                } else if (usert.getMusic() == null) {
                    usert.setMusic(txt);
                    userRepository.save(usert);
                    regSteps(id, ui, 22);
                }

            }


                 if (Integer.parseInt(update.getMessage().getText()) != 0 && Integer.valueOf(update.getMessage().getText()).equals(randomNumbers.get(inSearchOf.get(idList.indexOf(id))))) {

                     int rhe = idList.indexOf(idd);

                     int humanWhatWeCatch = inSearchOf.get(rhe);

                     functionWin(idd, humanWhatWeCatch);



                     int che = tableOfWinners.get(rhe);
                     if (che == 0) {tableOfWinners.set(rhe, 1);}
                     tableOfWinners.set(rhe, che +1);
                 }


             }

        } else if (update.hasCallbackQuery()) {

            String callbackData = update.getCallbackQuery().getData();
            long messageId = update.getCallbackQuery().getMessage().getMessageId();
            var chatId = update.getCallbackQuery().getMessage().getChatId();
            long id = update.getCallbackQuery().getMessage().getFrom().getId();
            if (userRepository.findById(idd).isPresent()){
                User usert = userRepository.findById(idd).get();
            //   var user = update.getMessage().getFrom();
            //    long id = user.getId();
            //  if (userRepository.findById(name).get().getPantstype().isEmpty(); System.out.println(step);}

            //  System.out.println(userRepository.findById(name).isPresent());
            //  System.out.println(getProgress(name));

            if (callbackData.equals(RAI_BUTTON)){
                int move = idList.indexOf(idd);
                int urValue = tableOfWinners.get(move);
                int y = 1;
                for (Integer tableOfWinner : tableOfWinners) {
                    if (tableOfWinner > urValue) {
                        y++;
                    }
                }

                int persentages = 100/tableOfWinners.size()*y;
                System.out.println("y = " + y +" ; idd = " + idd + " ; persentage = " + persentages);
                fromTableMess(idd, y, persentages);
            }

            if (callbackData.equals(HUNT_BUTTON)){
              //  deadend();

                int guff = idList.indexOf(idd);
             //id List
                Long endTime = System.currentTimeMillis();
                if (endTime - timeLast.get(guff) > 900000) {
                    timeLast.set(guff, endTime);
                    int perHum = search(idd, usert.getGender(), usert.getOrient(), usert.getSex(), usert.getCatdogs(), usert.getTeacoffie(), usert.getCookinglike(), usert.getDrunking(), usert.getHomeornot(), usert.getTechorhum());
                    if (perHum >= 0 && idd != idList.get(perHum)) {
                        NeutralMess(idd, generateParameters(perHum));
                        MatchLogic[guff][perHum] = true;

                        inSearchOf.set(guff, perHum);

                    } else {
                        NoSearchMes(idd);
                    }
                }else {
                    //15 min match
                    timeNotEnough(idd);
                }

            }

            if (callbackData.equals(START_BUTTON)) {
                regSteps(chatId, messageId, 1);
                //setProgress(1);
                //System.out.println("SUCCESS");
            }

             if (callbackData.equals(YES_BUTTON) || callbackData.equals(NO_BUTTON)) {
//                if (userRepository.findById(id).isPresent()){
//                    User usert = userRepository.findById(id).get();
                //System.out.println("yeteuei");
                if (usert.getWatch() == null) {
                    usert.setWatch(callbackData.equals(YES_BUTTON));
                    userRepository.save(usert);
                    regSteps(chatId, messageId, 23);
                } else if (usert.getOchechi() == null) {
                    usert.setOchechi(callbackData.equals(YES_BUTTON));
                    userRepository.save(usert);
                    regSteps(chatId, messageId, 24);
                } else if (usert.getPirce() == null) {
                    usert.setPirce(callbackData.equals(YES_BUTTON));
                    userRepository.save(usert);
                    regSteps(chatId, messageId, 25);
                } else if (usert.getBelt() == null) {
                    usert.setBelt(callbackData.equals(YES_BUTTON));
                    userRepository.save(usert);
                    regSteps(chatId, messageId, 26);
                } else if (usert.getChain() == null) {
                    usert.setChain(callbackData.equals(YES_BUTTON));
                    userRepository.save(usert);
                    regSteps(chatId, messageId, 27);
                } else if (usert.getMustage() == null) {
                    usert.setMustage(callbackData.equals(YES_BUTTON));
                    userRepository.save(usert);
                    regSteps(chatId, messageId, 28);
                } else if (usert.getCatdogs() == null) {
                    usert.setCatdogs(callbackData.equals(YES_BUTTON));
                    userRepository.save(usert);
                    regSteps(chatId, messageId, 29);
                } else if (usert.getTeacoffie() == null) {
                    usert.setTeacoffie(callbackData.equals(YES_BUTTON));
                    userRepository.save(usert);
                    regSteps(chatId, messageId, 30);
                } else if (usert.getCookinglike() == null) {
                    usert.setCookinglike(callbackData.equals(YES_BUTTON));
                    userRepository.save(usert);
                    regSteps(chatId, messageId, 31);
                } else if (usert.getDrunking() == null) {
                    usert.setDrunking(callbackData.equals(YES_BUTTON));
                    userRepository.save(usert);
                    regSteps(chatId, messageId, 32);
                } else if (usert.getHomeornot() == null) {
                    usert.setHomeornot(callbackData.equals(YES_BUTTON));
                    userRepository.save(usert);
                    regSteps(chatId, messageId, 33);
                } else if (usert.getTechorhum() == null) {
                    usert.setTechorhum(callbackData.equals(YES_BUTTON));
                    userRepository.save(usert);
                    regSteps(chatId, messageId, 34);
                } else if (usert.getGender() == null) {
                    usert.setGender(callbackData.equals(YES_BUTTON));
                    userRepository.save(usert);
                    regSteps(chatId, messageId, 35);
                } else if (usert.getOrient() == null) {
                    usert.setOrient(callbackData.equals(YES_BUTTON));
                    userRepository.save(usert);
                    regSteps(chatId, messageId, 36);
                } else if (usert.getSex() == null) {
                    usert.setSex(callbackData.equals(YES_BUTTON));
                    userRepository.save(usert);



                    idList.add(chatId);
                    randomNumbers.add(RandomGenerator());
                    persentConcveer.add(0);
                    timeLast.add(0L);
                    tableOfWinners.add(0);
                    inSearchOf.add(0);
                  //  test(111119938L, "test_1_Alex");
                  //  test( 222229938L, "test_2_Victoria");
                    NormalMess(chatId);
                }
            }

            }//yes or no pushed

//            if (userRepository.findById(name).isPresent() && userRepository.findById(name).get().getProgress() == (byte) 1) {
//                if (callbackData.equals(START_BUTTON)) {
//                    regSteps(chatId, messageId, (byte) 2);
//                }
//            }

        }

        }


    private void registerUser(Message msg) {

     if(userRepository.findById(msg.getChatId()).isEmpty()){

            Long chatId = msg.getChatId();
            var chat = msg.getChat();

            User user = new User();

            user.setChatId(chatId);
           // user.setFirstName(chat.getFirstName());
          //  user.setLastName(chat.getLastName());
            user.setUserName(chat.getUserName());
           // user.setProgress(chatId, 0);
            //user.setRegisteredAt(new Timestamp(System.currentTimeMillis()));

            userRepository.save(user);
           // log.info("user saved: " + user);
      }
    }
    public void setParam(Message msg){

    }

    public void sendMessage(Long who, String what){
        SendMessage sm = SendMessage.builder()
                .chatId(who.toString()) //Who are we sending a message to
                .text(what).build();    //Message content
        try {
            execute(sm);                        //Actually sending the message
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);      //Any error will be printed here
        }
    }

    public void copyMessage(Long who, Integer msgId){
        CopyMessage cm = CopyMessage.builder()
                .fromChatId(who.toString())  //We copy from the user
                .chatId(who.toString())      //And send it back to him
                .messageId(msgId)            //Specifying what message
                .build();
        try {
            execute(cm);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }

    private void startCommandReceived(long chatId, String name) {


        SendMessage message = new SendMessage();
        message.setChatId(String.valueOf(chatId));

        String answer = "Привет, " + name + ", и добро пожаловать на... \n \uD83C\uDF08 Ne Tinder COCKTAGE Dating \uD83C\uDF08! \n" +
                "Правила игры просты: \n" +
                "1. \uD83D\uDCD1 Заполняешь анкету, там несколько вопросов с текстовым ответом и парочка с кнопками. Это легко, " +
                "ведь все вопросы в этом тесте только про тебя \uD83D\uDC85. \n" +
                "2. \uD83C\uDFAF Нажимаешь начать охоту и тебе дают около 7-10 случайных характеристик о человеке" +
                ", которого нужно сыскать (глазками и лапками) на этом мероприятии.\n" +
                "3. \uD83D\uDD0E Если нашел(а), скорее знакомься. \uD83E\uDD16 Математически он/она/они твоя идеальная половинка! " +
                "Узнай у него/нее код и введи его ✅.\n" +
                "4. \uD83D\uDC68\u200D\uD83E\uDDB0\uD83D\uDCAC Ты тоже после заполнения анкеты, получишь свой собственный уникальный код (типа 1234), " +
                "свой код нужно сообщить человеку, который нашел тебя.\n" +
                "5. ❤ Всё просто: ты вводишь код и тебе дают 1 балл в рейтинговую таблицу и % вашей совместимости. " +
                "\n\n" +
                "\uD83C\uDFC6 В рейтинговой таблице " +
                "показываются самые быстрые спиддэйтеры. Вероятно, они могли подумать, что " +
                "их могут ожидать призы! \n\n"+
                "\uD83D\uDD25 Мы очень ценим вашу приватность. ВСЕ персональные данные (ответы на вопросы в анкете) " +
                "само уничтожатся по специальной команде \"завершения ивента\" \n\n" +
                "По всем вопросам организации этого ивента можно обращаться к @chajka_wazap. \n" +
                "Удачной охоты!" ;

        message.setText(answer);

        InlineKeyboardMarkup markupInLine = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rowsInLine = new ArrayList<>();
        List<InlineKeyboardButton> rowInLine = new ArrayList<>();
        var goButton = new InlineKeyboardButton();

        goButton.setText("Стартуем!");
        goButton.setCallbackData(START_BUTTON);

       // var noButton = new InlineKeyboardButton();

       // noButton.setText("Нет");
       // noButton.setCallbackData(NO_BUTTON);

        rowInLine.add(goButton);
       // rowInLine.add(noButton);

        rowsInLine.add(rowInLine);

        markupInLine.setKeyboard(rowsInLine);
        message.setReplyMarkup(markupInLine);

        executeMessage(message);

       // sendMessage(chatId, message);
    }

    private void NeutralMess(Long chatId, String MMS){
        SendMessage message = new SendMessage();
        message.setChatId(String.valueOf(chatId));
        String MMSSs = "Твой уникальный код " + randomNumbers.get(idList.indexOf(chatId)) + ". Сообщи его человеку, который найдет тебя. " + MMS ;
        message.setText(MMSSs);
        try{

            SetNormalButtons(message);

            execute(message);} catch (TelegramApiException e){
            System.out.println("ERR");
        }
    }
//генератор кода + КОД В SET PROGRESS
    private void NormalMess(Long chatId) {
        SendMessage message = new SendMessage();
        message.setChatId(String.valueOf(chatId));
        System.out.println(idList.get(0) + " <><><><><> " + randomNumbers.get(0) + " oioioi " + chatId);
        String MMSS = "Твой уникальный код " + randomNumbers.get(idList.indexOf(chatId)) + ". Сообщи его человеку, который найдет тебя. " +
                "Не забудь с ним познакомиться и хорошо провести время. Чтобы начать охоту, выбери новую цель. " +
                "Рейтинговая таблица периодические обновляется. ";
        message.setText(MMSS);
        try{

            SetNormalButtons(message);

            execute(message);} catch (TelegramApiException e){
            System.out.println("ERR");
        }
    }

    private void regSteps(Long chatId, long messageId, int step) {
//тут все этапы регистрации
        SendMessage message = new SendMessage();
        message.setChatId(String.valueOf(chatId));

if (step == 1){
    String ans1 = "Вопрос 1/36: Что на тебе надето снизу? \n" +
            "Напиши в чат. Например: \"джинсы\" или \"кожаная юбка миди\".\n" +
            "Интересен тип вещи, материал или марка. Цвет это отдельный вопрос!\n" +
            "Если ты в комбезе или платье, когда верх и низ одежды одно и тоже, " +
            "на этот и следующий вопрос ответ может быть идентичен. \n" +
            "Так же не пугайся количества вопросов, текстовых (не кнопочных) не так много.";
    message.setText(ans1);
    executeMessage(message);
} else if (step == 2) {
    String ans2 = "Вопрос 2/36: Что на тебе надето сверху? \n" +
            "Например: \"футболка с черепами\" или \"Платье BALENCIAGA\". " +
            "Не пиши о цвете, если это напрямую не указано в вопросе. \n" +
            "В среднем заполнение этой анкеты занимает около 2.5 минут.";
    message.setText(ans2);
    executeMessage(message);
} else if (step == 3) {
    String ans3 = "Вопрос 3/36: Аксессуар или телефон? \n " +
            "Тут может быть как сумочка, так и какой-то заметный аксессуар " +
            "вроде стальной цепочки или чокера (ну чтобы его было на тебе видно)" +
            ". На худой конец можно указать " +
            "марку телефона. Например: \"перстень с черепами\" или \"Nokia 1110\".";
    message.setText(ans3);
    executeMessage(message);
} else if (step == 4) {
    String ans4 = "Вопрос 4/36: Какая на тебе обувь?" +
            "Опять без цвета, интересен тип и возможно марка. Должно быть " +
            "что-то вроде: \"Кросы Reebok\", \"Туфли из замши\".";
    message.setText(ans4);
    executeMessage(message);
} else if (step == 5) {
    String ans5 = "Вопрос 5/36: Если ли татуировки на твоем теле? \n" +
          "Уточни где находится татуировка и что там изображено. Например: \"полу- и -сладкий " +
        "на обеих лодыжках\" или \"без тату\".";
    message.setText(ans5);
    executeMessage(message);
} else if (step == 6) {
    String ans6 = "Вопрос 6/36: Какой цвет штанов (или того что надето на тебе снизу)? \n" +
            "Например: \"черный\" или \"космические сливки (FFF8E7)\".";
    message.setText(ans6);
    executeMessage(message);
} else if (step == 7) {
    String ans7 = "Вопрос 7/36: Какой цвет у того что надето на тебе сверху? \n" +
            "Например: \"голубенький\" или \"розовый и желтый\".";
    message.setText(ans7);
    executeMessage(message);
} else if (step == 8) {
    String ans8 = "Вопрос 8/36: Напиши какой цвет носков на тебе или что на них " +
            "изображено? Вроде \"черные носки с перчиками\".";
    message.setText(ans8);
    executeMessage(message);
} else if (step == 9) {
    String ans9 = "Вопрос 9/36: Цвет обуви? \n" +
            "Текстовых вопросов осталось не так много, ты почти справился(ась)!";
    message.setText(ans9);
    executeMessage(message);
} else if (step == 10) {
    String ans10 = "Вопрос 10/36: Цвет нижнего белья? \n" +
            "Напомню, что начиная условную охоту, человек получает всего несколько " +
            "случайных характеристик, которые в свою очередь " +
            "объеденины по группам. Этот вопрос " +
            "нужен для балансировки такой системы, и делает игру более интересной.";
    message.setText(ans10);
    executeMessage(message);
} else if (step == 11) {
    String ans11 = "Вопрос 11/36: Укажи свой рост числом? \n" +
            "Именно просто число (в сантиметрах)! Например: \"188\".";
    message.setText(ans11);
    executeMessage(message);
} else if (step == 12) {
    String ans12 = "Вопрос 12/36: Напиши свой примерный вес числом? (кг)\n" +
            "Опять таки число, например: \"72\".";
    message.setText(ans12);
    executeMessage(message);
} else if (step == 13) {
    String ans13 = "Вопрос 13/36: Какой у тебя размер ноги (числом)? \n" +
            "Это последний такой вопрос, допустим: \"43\".";
    message.setText(ans13);
    executeMessage(message);
} else if (step == 14) {
    String ans14 = "Вопрос 14/36: Укажи цвет своих волос? \n" +
            "Например: \"русые\" или \"брюнетные\".";
    message.setText(ans14);
    executeMessage(message);
} else if (step == 15) {
    String ans15 = "Вопрос 15/36: Какое у тебя телосложение? \n " +
            "Например: \"дохлятное\", \"умеренное\" или \"кач всех качей\".";
    message.setText(ans15);
    executeMessage(message);
} else if (step == 16) {
    String ans16 = "Вопрос 16/36: Укажи цвет твоих глаз? ";
    message.setText(ans16);
    executeMessage(message);
} else if (step == 17) {
    String ans17 = "Вопрос 17/36: Напиши о своих хобби? Что тебя увлекает и занимает?\n" +
            "Например: \"смотрю сериалы (слишком много)\" или \"качаю бицуху, нефть и торренты\".";
    message.setText(ans17);
    executeMessage(message);
} else if (step == 18) {
    String ans18 = "Вопрос 18/36: В каком вузе ты учишься? \n" +
            "Напиши сокращенно, вроде \"МГУ\", \"МИФИ\" или \"HSE\"";
    message.setText(ans18);
    executeMessage(message);
} else if (step == 19) {
    String ans19 = "Вопрос 19/36: Какая твоя любимая еда? \n" +
            "Например: \"Спагетти с сыром\" или \"Коттеджные салаты\".";
    message.setText(ans19);
    executeMessage(message);
} else if (step == 20) {
    String ans20 = "Вопрос 20/36: Какой твой любимый фильм? \n" +
            "Например: \"Завтрак у Тиффани\", \"Дело было в Пенькове\" или \"Любовь и голуби\".";
    message.setText(ans20);
    executeMessage(message);
} else if (step == 21) {
    String ans21 = "Вопрос 21/36: Какой твой любимый жанр музыки? \n" +
            "Это последний текстовый ответ, просто вспомни любимый жанр, вроде: \"Тайское диско\".";//тут заканчиваются текстовые вопросы
    message.setText(ans21);
    executeMessage(message);
} else if (step == 22) {
    String ans22 = "Вопрос 22/36: Носишь наручные часы? \n" +
            "При этом их должно быть видно, так же это правило эквивалентно и для последующих вопросов.";
    message.setText(ans22);
    executeMassageYesNo(message);
} else if (step == 23) {
    String ans23 = "Вопрос 23/36: На тебе сейчас надеты очки?";
    message.setText(ans23);
    executeMassageYesNo(message);
} else if (step == 24) {
    String ans24 = "Вопрос 24/36: У тебя есть серьги или пирсинг на видном месте?";
    message.setText(ans24);
    executeMassageYesNo(message);
} else if (step == 25) {
    String ans25 = "Вопрос 25/36: На тебе сейчас есть пояс или ремень?";
    message.setText(ans25);
    executeMassageYesNo(message);
} else if (step == 26) {
    String ans26 = "Вопрос 26/36: Ты носишь цепочку на шее?";
    message.setText(ans26);
    executeMassageYesNo(message);
} else if (step == 27) {
    String ans27 = "Вопрос 27/36: Носишь шикарную бороду и/или фешенебельные усы?";
    message.setText(ans27);
    executeMassageYesNo(message);
} else if (step == 28) {
    String ans28 = "Вопрос 28/36: Ты больше любишь кошек или собак?";
    message.setText(ans28);
    try{
    //executeMessage(message); //cat dog
    InlineKeyboardMarkup markupInLine = new InlineKeyboardMarkup();
    List<List<InlineKeyboardButton>> rowsInLine = new ArrayList<>();
    List<InlineKeyboardButton> rowInLine = new ArrayList<>();
    var yesButton = new InlineKeyboardButton();
    yesButton.setText("Котики");
    yesButton.setCallbackData(YES_BUTTON);

    var noButton = new InlineKeyboardButton();

    noButton.setText("Песики");
    noButton.setCallbackData(NO_BUTTON);

    rowInLine.add(yesButton);
    rowInLine.add(noButton);

    rowsInLine.add(rowInLine);

    markupInLine.setKeyboard(rowsInLine);
    message.setReplyMarkup(markupInLine);

    execute(message);} catch (TelegramApiException e){
        System.out.println("ERR");
    }
} else if (step == 29) {
    String ans29 = "Вопрос 29/36: Что тебе нравится больше, вкусный чай или ароматный кофе?";
    message.setText(ans29);
    try{
        //executeMessage(message); //cat dog
        InlineKeyboardMarkup markupInLine = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rowsInLine = new ArrayList<>();
        List<InlineKeyboardButton> rowInLine = new ArrayList<>();
        var yesButton = new InlineKeyboardButton();
        yesButton.setText("Чай");
        yesButton.setCallbackData(YES_BUTTON);

        var noButton = new InlineKeyboardButton();

        noButton.setText("Кофе");
        noButton.setCallbackData(NO_BUTTON);

        rowInLine.add(yesButton);
        rowInLine.add(noButton);

        rowsInLine.add(rowInLine);

        markupInLine.setKeyboard(rowsInLine);
        message.setReplyMarkup(markupInLine);

        execute(message);} catch (TelegramApiException e){
        System.out.println("ERR");
    }
} else if (step == 30) {
    String ans30 = "Вопрос 30/36: Любишь ли ты готовить? Доставляет ли тебе готовка удовольствие?";
    message.setText(ans30);
    executeMassageYesNo(message);
} else if (step == 31) {
    String ans31 = "Вопрос 31/36: Можно ли с тобой выпить чего-то крепкого на первом свидании?";
    message.setText(ans31);
    executeMassageYesNo(message);
} else if (step == 32) {
    String ans32 = "Вопрос 32/36: Считаешь себя больше домашним(ей)? или больше любишь всякий движ?";
    message.setText(ans32);
    try{
        //executeMessage(message); //cat dog
        InlineKeyboardMarkup markupInLine = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rowsInLine = new ArrayList<>();
        List<InlineKeyboardButton> rowInLine = new ArrayList<>();
        var yesButton = new InlineKeyboardButton();
        yesButton.setText("Домашний(яя)");
        yesButton.setCallbackData(YES_BUTTON);

        var noButton = new InlineKeyboardButton();

        noButton.setText("За Движ");
        noButton.setCallbackData(NO_BUTTON);

        rowInLine.add(yesButton);
        rowInLine.add(noButton);

        rowsInLine.add(rowInLine);

        markupInLine.setKeyboard(rowsInLine);
        message.setReplyMarkup(markupInLine);

        execute(message);} catch (TelegramApiException e){
        System.out.println("ERR");
    }
} else if (step == 33) {
    String ans33 = "Вопрос 33/36: Ты больше технарь или гуманитарий?";
    message.setText(ans33);
    try{
        //executeMessage(message); //cat dog
        InlineKeyboardMarkup markupInLine = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rowsInLine = new ArrayList<>();
        List<InlineKeyboardButton> rowInLine = new ArrayList<>();
        var yesButton = new InlineKeyboardButton();
        yesButton.setText("Технарь");
        yesButton.setCallbackData(YES_BUTTON);

        var noButton = new InlineKeyboardButton();

        noButton.setText("Гуманитарий");
        noButton.setCallbackData(NO_BUTTON);

        rowInLine.add(yesButton);
        rowInLine.add(noButton);

        rowsInLine.add(rowInLine);

        markupInLine.setKeyboard(rowsInLine);
        message.setReplyMarkup(markupInLine);

        execute(message);} catch (TelegramApiException e){
        System.out.println("ERR");
    }
} else if (step == 34) { //местоимения
    String ans34 = "Вопрос 34/36: С каким местоимением можно к тебе обращаться? \n";
    message.setText(ans34);
    executeMassageMenGirl(message); // male or female
} else if (step == 35) { //?? ты открыт для романтических знакомств?
    String ans35 = "Вопрос 35/36: Открыт ли ты для романтических знакомств?";
    message.setText(ans35);
    executeMassageYesNo(message); // gay or bi
} else if (step == 36) { //любишь обнимать или когда обнимают тебя?
    String ans36 = "Вопрос 36/36: Тебе больше нравится обнимать кого-то самому или когда обнимают тебя?";
    message.setText(ans36);
    executeMassageTopBot(message); // top or bottom
}


    }

    private void executeMessage(SendMessage message){
        try {
            execute(message);
        } catch (TelegramApiException e) {
           // log.error(ERROR_TEXT + e.getMessage());
        }
    }

    private void executeMassageYesNo(SendMessage message){
        try {
            InlineKeyboardMarkup markupInLine = new InlineKeyboardMarkup();
            List<List<InlineKeyboardButton>> rowsInLine = new ArrayList<>();
            List<InlineKeyboardButton> rowInLine = new ArrayList<>();
            var yesButton = new InlineKeyboardButton();
            yesButton.setText("Да");
            yesButton.setCallbackData(YES_BUTTON);

            var noButton = new InlineKeyboardButton();

            noButton.setText("Нет");
            noButton.setCallbackData(NO_BUTTON);

            rowInLine.add(yesButton);
            rowInLine.add(noButton);

            rowsInLine.add(rowInLine);

            markupInLine.setKeyboard(rowsInLine);
            message.setReplyMarkup(markupInLine);

            execute(message);
        } catch (TelegramApiException e){
            System.out.println("ERROR");
        }
    }

    private void executeMassageMenGirl(SendMessage message){
        try {
            InlineKeyboardMarkup markupInLine = new InlineKeyboardMarkup();
            List<List<InlineKeyboardButton>> rowsInLine = new ArrayList<>();
            List<InlineKeyboardButton> rowInLine = new ArrayList<>();
            var yesButton = new InlineKeyboardButton();
            yesButton.setText("Он");
            yesButton.setCallbackData(YES_BUTTON);

            var noButton = new InlineKeyboardButton();

            noButton.setText("Она");
            noButton.setCallbackData(NO_BUTTON);

            var whatButton = new InlineKeyboardButton();
            whatButton.setText("Они");
            Random rd = new Random();
            if(rd.nextBoolean()){whatButton.setCallbackData(YES_BUTTON);}else {whatButton.setCallbackData(NO_BUTTON);}


            rowInLine.add(yesButton);
            rowInLine.add(noButton);
            rowInLine.add(whatButton);

            rowsInLine.add(rowInLine);

            markupInLine.setKeyboard(rowsInLine);
            message.setReplyMarkup(markupInLine);

            execute(message);
        } catch (TelegramApiException e){
            System.out.println("ERROR");
        }
    }

    private void executeMassageTopBot(SendMessage message){
        try {
            InlineKeyboardMarkup markupInLine = new InlineKeyboardMarkup();
            List<List<InlineKeyboardButton>> rowsInLine = new ArrayList<>();
            List<InlineKeyboardButton> rowInLine = new ArrayList<>();
            var yesButton = new InlineKeyboardButton();
            yesButton.setText("Самому");
            yesButton.setCallbackData(YES_BUTTON);

            var noButton = new InlineKeyboardButton();

            noButton.setText("Меня");
            noButton.setCallbackData(NO_BUTTON);

            rowInLine.add(yesButton);
            rowInLine.add(noButton);

            rowsInLine.add(rowInLine);

            markupInLine.setKeyboard(rowsInLine);
            message.setReplyMarkup(markupInLine);

            execute(message);
        } catch (TelegramApiException e){
            System.out.println("ERROR");
        }
    }
    /*
    private void executeEditMessageText(String text, long chatId, long messageId){
        EditMessageText message = new EditMessageText();
        message.setChatId(String.valueOf(chatId));
        message.setText(text);
        message.setMessageId((int) messageId);

        try {
            execute(message);
        } catch (TelegramApiException e) {
           // log.error(ERROR_TEXT + e.getMessage());
        }
    }
*/





    public int RandomGenerator (){
        return ThreadLocalRandom.current().nextInt(1111, 9998 + 1);
    }

    public int search(Long id1, boolean gender, boolean orient, boolean sex, boolean cat, boolean tea, boolean cooking, boolean alcohol, boolean home, boolean tech){

       int[] reiting = new int[idList.size()];

       for (int i = 0; i < reiting.length; i++){
           long id2 = idList.get(i);
           if (userRepository.findById(id2).isPresent()){
               User userp = userRepository.findById(id2).get();
               if (orient && userp.getGender() == gender){
                   reiting[i] += 1000;
               } else if (!orient && userp.getGender() != gender) {
                   reiting[i] += 1000;
               } else {reiting[i] += 500;}
               if (!sex == userp.getSex()) {reiting[i] += 100;}
               if (cat == userp.getCatdogs()) {reiting[i] += 10;}
               if (tea == userp.getTeacoffie()) {reiting[i] += 10;}
               if (!cooking == userp.getCookinglike()) {reiting[i] += 10;}
               if (alcohol == userp.getDrunking()) {reiting[i] += 10;}
               if (home == userp.getHomeornot()) {reiting[i] += 10;}
               if (tech == userp.getTechorhum()) {reiting[i] += 10;}


           }
       }


        reiting[idList.indexOf(id1)] = -1;
        for (int k = 0; k < 200; k++){
            if (MatchLogic[idList.indexOf(id1)][k]) {reiting[k] = -1;}
        }

       int MAX = -1;
        for (int i : reiting) {
            if (i > MAX) {
                MAX = i;
            }
        }
        persentConcveer.set(idList.indexOf(id1), MAX);
        int finalle = 0;
        for (int j = 0; j < reiting.length; j++){
            if (reiting[j] == MAX) {finalle = j;}
        }
        return finalle;
    }



    public String generateParameters(int fromListN){

        long ids = idList.get(fromListN);
        String mainPar = "Охота началась! Найди свою пару по этим характеристикам, познакомься и после спроси его уникальный код. " +
                "Напиши этот код сюда. \n\n" ;

        String gen, gen0, gen1, gen2, gen3, gen4, gen5;
        if (userRepository.findById(ids).isPresent()){
            User userf = userRepository.findById(ids).get();
            if (userf.getGender()){gen = "нем";} else {gen = "ней";}
            if (userf.getGender()){gen0 = "он";} else {gen0 = "она";}
            if (userf.getGender()){gen1 = "Он";} else {gen1 = "Она";}
            if (userf.getGender()){gen2 = "его";} else {gen2 = "её";}
            if (userf.getGender()){gen3 = "него";} else {gen3 = "неё";}
            if (userf.getGender()){gen4 = "Его";} else {gen4 = "Её";}
            if (userf.getGender()){gen5 = "ним";} else {gen5 = "ней";}

                int rndm = ThreadLocalRandom.current().nextInt(0, 100 + 1);
                    if (rndm < 20){
                        mainPar += "На " + gen + " снизу надето: " + userf.getPantstype() + ". ";
                    } else if (rndm < 40) {
                        mainPar += "На " + gen + " сверху надето: " + userf.getTopestype() + ". ";
                    } else if (rndm < 60) {
                        mainPar += gen1 + " как правило носит с собой: " + userf.getPhonetype() + ". ";
                    } else if (rndm < 80) {
                        mainPar += "На " + gen2 + " ногах шикарно сидят: " + userf.getShoestype() + ". ";
                    } else {mainPar += "На " + gen2 + " коже можно найти тату или родинку: " + userf.getTattostype() + ". ";}

                rndm = ThreadLocalRandom.current().nextInt(0, 100 + 1);
            if (rndm < 20){
                mainPar += "Цвет верхней части " + gen2 + " лука: " + userf.getTopescolor() + ". ";
            } else if (rndm < 40) {
                mainPar += "Цвет нижней части " + gen2 + " лука: " + userf.getPantscoolor() + ". ";
            } else if (rndm < 60) {
                mainPar += "У " + gen3 + " носки: " + userf.getSoxcolor() + ". ";
            } else if (rndm < 80) {
                mainPar += "Цвет " + gen2 + " башмачков: " + userf.getShoescolor() + ". ";
            } else {mainPar += "На " + gen + " нижнее белье: " + userf.getTattostype() + ". ";}

                rndm = ThreadLocalRandom.current().nextInt(0, 100 + 1);
                if (rndm < 33){
                    mainPar += gen4 + " рост примерно: " + userf.getHeight() + " см. ";
                } else if (rndm < 66) {
                    mainPar += gen4 + " вес около: " + userf.getWeight() + " кг. ";
                } else {mainPar += "Размер " + gen2 + " обуви: " + userf.getShoessize()+ ". ";}

            rndm = ThreadLocalRandom.current().nextInt(0, 100 + 1);
            if (rndm < 33){
                mainPar += gen4 + " цвет волос: " + userf.getHaircolor() + ". ";
            } else if (rndm < 66) {
                mainPar += gen4 + " телосложение: " + userf.getBodytype() + ". ";
            } else {mainPar += "Цвет " + gen2 + " глаз: " + userf.getEyecolor() + ". ";}

            rndm = ThreadLocalRandom.current().nextInt(0, 100 + 1);
            if (rndm < 20){
                mainPar += "В свободное время " + gen0 + ": " + userf.getHobby()+ ". ";
            } else if (rndm < 40) {
                mainPar += gen1 + " учится в: " + userf.getStudy() + ". ";
            } else if (rndm < 60) {
                mainPar += gen4 + " любимая еда: " + userf.getFood() + ". ";
            } else if (rndm < 80) {
                mainPar += gen4 + " любимый фильм: " + userf.getFilm() + ". ";
            } else {mainPar += gen4 + " любимый музыкальный жанр это: " + userf.getMusic() + ". ";}

            if (userf.getMustage()){
                mainPar += "У " + gen3 + " шикарная борода или усы. ";
            } else if (userf.getOchechi()) {
                mainPar += gen1 + " носит очки. ";
            } else if (userf.getWatch()) {mainPar += "На " + gen2 + " руке часы отсчитывают время. ";
            } else {
                rndm = ThreadLocalRandom.current().nextInt(0, 100 + 1);
                if (rndm < 33){
                    mainPar += gen1 + " не носит наручные часы. ";
                } else if (rndm < 66) {
                    mainPar += gen1 + " не носит очки. ";
                } else {mainPar += gen1 + " не носит бороды или усов. ";}
            }

            if (userf.getPirce()){
                mainPar += "На " + gen + " надеты серьги или пирсинг. ";
            } else if (userf.getChain()) {
                mainPar += "На " + gen2 + " шее есть цепочка. ";
            } else if (userf.getBelt()) {mainPar += gen1 + " носит ремень или пояс. ";
            } else {
                rndm = ThreadLocalRandom.current().nextInt(0, 100 + 1);
                if (rndm < 33){
                    mainPar += gen1 + " не носит сережки или пирсинг. ";
                } else if (rndm < 66) {
                    mainPar += gen1 + " не носит цепочку на шее. ";
                } else {mainPar += gen1 + " не носит ремень или пояс. ";}
            }

                rndm = ThreadLocalRandom.current().nextInt(0, 100 + 1);
                if (rndm < 33){
                    if (userf.getCatdogs()) {
                        mainPar += gen1 + " обожает котиков. ";} else {mainPar += gen1 + " больше любит собак. ";}
                } else if (rndm < 66) {
                    if (userf.getTeacoffie()){
                        mainPar += gen1 + " наверняка не откажется от чашки чая. ";} else {mainPar += gen1 + " наверняка не откажется от чашки кофе. ";}
                } else {
                    if (userf.getCookinglike()){
                        mainPar += gen1 + " умеет и любит готовить. ";} else { mainPar += "C " + gen5 + " лучше научиться готовить самому. ";}
                }

            rndm = ThreadLocalRandom.current().nextInt(0, 100 + 1);
            if (rndm < 33){
                if (userf.getCatdogs()) {
                    mainPar += gen1 + " обожает котиков. ";} else {mainPar += gen1 + " больше любит собак. ";}
            } else if (rndm < 66) {
                if (userf.getHomeornot()){
                    mainPar += "C " + gen5 + " можно уютно посидеть дома. ";} else {mainPar += "C " + gen5 + " классно куда-то выбраться. ";}
            } else {
                if (userf.getDrunking()){
                    mainPar += "C " + gen5 + " можно выпить чего-то крепкого. ";} else { mainPar += "C " + gen5 + " вряд ли получится выпить чего-то крепкого. ";}
            }

        }
        return mainPar;
    }
    private void NoSearchMes(Long chatId) {
        SendMessage message2 = new SendMessage();
        message2.setChatId(String.valueOf(chatId));
        String SS = "Кажется ты познакомился со всеми доступными пользователями, попробуй начать новую охоту позднее. \n" +
                "Твой уникальный код " + randomNumbers.get(idList.indexOf(chatId)) + ". Сообщи его человеку, который найдет тебя. " +
                "Не забудь с ним познакомиться и хорошо провести время. Чтобы начать охоту, выбери новую цель. " +
                "Рейтинговая таблица периодические обновляется";
        message2.setText(SS);
        try{

            SetNormalButtons(message2);

            execute(message2);} catch (TelegramApiException e){
            System.out.println("ERR");
        }
    }
//functionWin
private void functionWin(Long chatId, int hh) {
    SendMessage messageUltima = new SendMessage();
    messageUltima.setChatId(String.valueOf(chatId));
    float gf = (float) 100 / 1660 * ( persentConcveer.get(idList.indexOf(chatId)));
    tableOfWinners.set(idList.indexOf(chatId), tableOfWinners.get(idList.indexOf(chatId))+1);
    timeLast.set(idList.indexOf(chatId), 0L);
    String SS = "Поздравляю, ты успешно нашел свою пару! " +
            "Вы совместимы на "+ gf + "%.\n" +
            "Рейтинговая таблица обновленна. " +
            "Так же напоминаю, твой уникальный код " + randomNumbers.get(idList.indexOf(chatId)) + ". Сообщи его человеку, который найдет тебя. " +
            "Не забудь с ним познакомиться и хорошо провести время. Чтобы начать охоту, выбери новую цель. " +
            "";
    messageUltima.setText(SS);

try {
    SetNormalButtons(messageUltima);
    execute(messageUltima);
} catch (TelegramApiException e){
    System.out.println("ERR");
}

}

    private void timeNotEnough(Long chatId) {
        SendMessage messageUlt = new SendMessage();
        messageUlt.setChatId(String.valueOf(chatId));
        String SS = "Начать новую охоту, не завершив предыдущую можно не чаще чем раз в 15 минут. Подожди или найди человека и введи его код. " +
                "Твой уникальный код по-прежнему " + randomNumbers.get(idList.indexOf(chatId)) + ". Сообщи его человеку, который найдет тебя. " +
                "Не забудь с ним познакомиться и хорошо провести время. Чтобы начать охоту, выбери новую цель. " +
                "";
        messageUlt.setText(SS);

        try {
            SetNormalButtons(messageUlt);
            execute(messageUlt);
        } catch (TelegramApiException e){
            System.out.println("ERR");
        }

    }
    // HUNT RAIT


    private void fromTableMess(Long chatId, int y, int persent) {
        SendMessage messageUlt = new SendMessage();
        messageUlt.setChatId(String.valueOf(chatId));
        String SS = "Твое место в рейтинговой таблице: "+ y + " ! Ты среди "+ persent + "% самых быстрых спиддейтеров." +
                "Твой код как и обычно " + randomNumbers.get(idList.indexOf(chatId)) + ". Сообщи его человеку, который найдет тебя. " +
                "Не забудь с ним познакомиться и хорошо провести время. Чтобы начать охоту, выбери новую цель. " +
                "";
        messageUlt.setText(SS);

        try {
            SetNormalButtons(messageUlt);
            execute(messageUlt);
        } catch (TelegramApiException e){
            System.out.println("ERR");
        }

    }
    private void SetNormalButtons (SendMessage messageTo){

            InlineKeyboardMarkup markupInLine = new InlineKeyboardMarkup();
            List<List<InlineKeyboardButton>> rowsInLine = new ArrayList<>();
            List<InlineKeyboardButton> rowInLine = new ArrayList<>();
            var huntButton = new InlineKeyboardButton();
            huntButton.setText("Новая охота");
            huntButton.setCallbackData(HUNT_BUTTON);

            var raiButton = new InlineKeyboardButton();

            raiButton.setText("Рейтинг");
            raiButton.setCallbackData(RAI_BUTTON);

            rowInLine.add(huntButton);
            rowInLine.add(raiButton);

            rowsInLine.add(rowInLine);

            markupInLine.setKeyboard(rowsInLine);
            messageTo.setReplyMarkup(markupInLine);

        }

//private void test (Long idtest, String name){
//  //  userList.add(name);
//    idList.add(idtest);
//    randomNumbers.add(RandomGenerator());
//    System.out.println(" ---------->" + randomNumbers.get(0) + " " + randomNumbers.get(1) + " " );
//    persentConcveer.add(0);
//    timeLast.add(0L);
//    tableOfWinners.add(0);
//    inSearchOf.add(0);
//
    /*

private void deadend (){

        System.out.println("<< LOG REPORT >>");
       // System.out.println(Arrays.deepToString(MatchLogic));
        System.out.println(randomNumbers.toString());
        System.out.println(inSearchOf.toString());
        System.out.println(tableOfWinners.toString());
        System.out.println(idList.toString());
        System.out.println(persentConcveer.toString());
        System.out.println(timeLast.toString());

}



*/


}

