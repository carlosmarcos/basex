package org.basex.core.cmd;

import static org.basex.core.Text.*;

import org.basex.core.Command;
import org.basex.core.CommandBuilder;
import org.basex.core.User;
import org.basex.core.Commands.Cmd;
import org.basex.core.Commands.CmdCreate;

/**
 * Evaluates the 'create trigger' command and creates a new trigger.
 *
 * @author BaseX Team 2005-11, BSD License
 * @author Roman Raedle
 * @author Andreas Weiler
 */
public final class CreateTrigger extends Command {
  /**
   * Default constructor.
   * @param name user name
   */
  public CreateTrigger(final String name) {
    super(User.ADMIN, name);
  }

  @Override
  protected boolean run() {
    final String name = args[0];
    if(context.triggers.create(name)) {
      return info(TRIGGERCREATE, name);
    }
    return error(TRIGGERKNOWN, name);
  }

  @Override
  public void build(final CommandBuilder cb) {
    cb.init(Cmd.CREATE + " " + CmdCreate.TRIGGER).args();
  }
}